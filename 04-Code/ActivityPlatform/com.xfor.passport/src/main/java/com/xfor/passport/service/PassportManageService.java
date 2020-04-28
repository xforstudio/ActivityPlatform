package com.xfor.passport.service;

import com.xfor.infrastructure.model.IDateTimeProvider;
import com.xfor.infrastructure.model.TextCaptcha;
import com.xfor.infrastructure.service.*;
import com.xfor.passport.model.Passport;
import com.xfor.passport.model.PassportException;
import com.xfor.passport.model.PassportLoginSession;
import com.xfor.passport.model.PassportRegist;
import com.xfor.passport.repository.IPassportAuthCategoryRepository;
import com.xfor.passport.repository.IPassportAuthRepository;
import com.xfor.passport.repository.IPassportIDRepository;
import com.xfor.passport.repository.IPassportRepository;

public class PassportManageService extends BaseService implements IPassportAuthManageService {

    private IPassportRepository passportRepository;
    private IPassportAuthRepository passportAuthRepository;
    private IPassportAuthCategoryRepository passportAuthCategoryRepository;
    private IPassportIDRepository passportIDRepository;
    private ISmsService smsService;
    private IEmailService emailService;
    private ITextCaptchaLogService textCaptchaLogService;
    private IDateTimeProvider dateTimeProvider;

    public PassportManageService(
        IPassportRepository passportRepository,
        IPassportAuthRepository passportAuthRepository,
        IPassportAuthCategoryRepository passportAuthCategoryRepository,
        IPassportIDRepository passportIDRepository,
        ISmsService smsService,
        IEmailService emailService,
        ITextCaptchaLogService textCaptchaLogService,
        IDateTimeProvider dateTimeProvider)
    {
        super();
        this.passportRepository = passportRepository;
        this.passportAuthRepository = passportAuthRepository;
        this.passportAuthCategoryRepository = passportAuthCategoryRepository;
        this.passportIDRepository = passportIDRepository;
        this.smsService = smsService;
        this.emailService = emailService;
        this.textCaptchaLogService = textCaptchaLogService;
        this.dateTimeProvider = dateTimeProvider;
    }

    //发送短信验证码
    protected void doSendSmsCaptcha(String mobile, String category) {
        //发送验证码
        String captcha = TextCaptcha._newNumCode();
        this.smsService.send(mobile, captcha);
        this.textCaptchaLogService.setCaptcha(category, mobile, captcha);
    }

    //发送邮件验证码
    protected void doSendEmailCaptcha(String email, String category) {
        //发送验证码
        String captcha = TextCaptcha._newNumCode();
        this.emailService.send(email, captcha);
        this.textCaptchaLogService.setCaptcha(category, email, captcha);
    }

    //判断登录标识是否有效
    public boolean isLoginTokenValid(String loginToken) {
        ServiceContext sctx = this.doGetServiceContext();
        Boolean isValid = this.passportRepository.ExistsLoginToken(loginToken, sctx);
        return isValid;
    }

    public void verifyLoginToken(String loginToken) throws PassportException {
        ServiceContext sctx = this.doGetServiceContext();
        Boolean isValid = this.passportRepository.ExistsLoginToken(loginToken, sctx);
        if (!isValid) {
            throw new PassportException("会话标识无效");
        }
    }

    public void clearLoginTokens(int durationLimit) {
        return;
    }

    //凭据密码登录
    public PassportLoginSession loginByCredAndPwd(String credential, String password)
            throws PassportException {
        ServiceContext sctx = this.doGetServiceContext();
        //获取Passport
        Passport passport = this.passportRepository.GetPassportByCredential(credential, sctx);
        if (passport == null) {
            throw new PassportException("通行证不存在");
        }
        //验证密码
        if (!passport.matchPassword(password)) {
            throw new PassportException("密码错误");
        }
        //登录
        PassportLoginSession loginSession = passport.Login(this.dateTimeProvider);
        //保存通行证
        this.passportRepository.SavePassport(passport, sctx);
        //
        return loginSession;
    }

    //短信验证码登录
    public PassportLoginSession loginBySms(String mobile, String captcha)
            throws PassportException {
        ServiceContext sctx = this.doGetServiceContext();
        //检查验证码
        String captcha_pre = this.textCaptchaLogService.pickCaptcha("_login", mobile);
        if (captcha == null || captcha != captcha_pre) {
            throw new PassportException("验证码无效");
        }
        //获取通行证
        Passport passport = this.passportRepository.GetPassportByMobile(mobile, sctx);
        if (passport == null) {
            throw new PassportException("通行证不存在");
        }
        //登录
        PassportLoginSession loginSession = passport.login(this.dateTimeProvider);
        //保存通行证
        this.passportRepository.SavePassport(passport, sctx);
        //
        return loginSession;
    }

    //登出
    public void logout(String loginToken)
            throws PassportException {
        ServiceContext sctx = this.doGetServiceContext();
        //获取通行证
        Passport passport = this.passportRepository.GetPassportByLoginToken(loginToken, sctx);
        if (passport == null) {
            throw new PassportException("登录会话标识无效");
        }
        //登出
        passport.logout(loginToken);
        //保存通行证
        this.passportRepository.SavePassport(passport, sctx);
    }

    //发送短信验证码
    public void sendSmsCaptchaWithLogin(String mobile) {
        this.doSendSmsCaptcha(mobile,"_login");
    }

    //通行证注册
    public void registPassport(PassportRegist passportRegist)
            throws PassportException {
        ServiceContext sctx = this.doGetServiceContext();
        //有效性验证
        passportRegist.validate();
        //业务验证（手机）
        if (passportRegist.isMobileSet()) {
            boolean existsMobile = this.passportRepository.ExistsMobile(passportRegist.Mobile, sctx);
            if (existsMobile) {
                throw new PassportException("手机号已存在");
            }
        }
        //业务验证（邮箱）
        if (passportRegist.isEmailSet()) {
            boolean existsEmail = this.passportRepository.ExistsEmail(passportRegist.Email, sctx);
            if (existsEmail) {
                throw new PassportException("邮箱已存在");
            }
        }
        //创建通行证
        Passport passport = passportRegist.createPassport(this.dateTimeProvider);
        //保存通行证
        this.passportRepository.SavePassport(passport, sctx);
    }
    
    /// <summary>
    /// 重置密码（手机认证）
    /// </summary>
    /// <param name="newPwd"></param>
    /// <param name="mobile"></param>
    /// <param name="captcha"></param>
    public void ResetPasswordWithMobile(string newPwd, string mobile, string captcha)
    {
        //检查验证码
        string captcha_pre = this.textCaptchaLogService.PickCaptcha("_reset_pwd_mobile", mobile);
        if (captcha == null || captcha != captcha_pre)
        {
            throw new System.Exception("验证码无效");
        }
        //
        ServiceContext sctx = this.DoGetServiceContext();
        //获取通行证
        Passport passport = this.passportRepository.GetPassportByMobile(mobile, sctx);
        if (passport == null)
        {
            throw new System.Exception("通行证不存在");
        }
        //设置密码
        passport.SetPassword(newPwd, this.dateTimeProvider);
        //保存通行证
        this.passportRepository.SavePassport(passport, sctx);
    }

    /// <summary>
    /// 重置密码（邮箱认证）
    /// </summary>
    /// <param name="newPwd"></param>
    /// <param name="mobile"></param>
    /// <param name="captcha"></param>
    public void ResetPasswordWithEmail(string newPwd, string email, string captcha)
    {
        //检查验证码
        string captcha_pre = this.textCaptchaLogService.PickCaptcha("_reset_pwd_email", email);
        if (captcha == null || captcha != captcha_pre)
        {
            throw new System.Exception("验证码无效");
        }
        //
        ServiceContext sctx = this.DoGetServiceContext();
        //获取通行证
        Passport passport = this.passportRepository.GetPassportByEmail(email, sctx);
        if (passport == null)
        {
            throw new System.Exception("通行证不存在");
        }
        //设置密码
        passport.SetPassword(newPwd, this.dateTimeProvider);
        //保存通行证
        this.passportRepository.SavePassport(passport, sctx);
    }

    /// <summary>
    /// 发送重置密码短信验证码
    /// </summary>
    /// <param name="mobile"></param>
    public void SendSmsCaptchaWithResetPassword(string mobile)
    {
        this.DoSendSmsCaptcha(mobile, "_reset_pwd_mobile");
    }

    /// <summary>
    /// 发送重置密码邮件验证码
    /// </summary>
    /// <param name="email"></param>
    public void SendEmailCaptchaWithResetPassword(string email)
    {
        this.DoSendEmailCaptcha(email, "_reset_pwd_email");
    }

        #endregion

        #region 信息管理

    public Passport GetPassportByPassportSID(string passportSID)
    {
        ServiceContext sctx = this.DoGetServiceContext();
        //获取通行证
        Passport passport = this.passportRepository.GetPassportBySID(passportSID, sctx);
        return passport;
    }

    public string GetPassportSIDByLoginToken(string loginToken)
    {
        ServiceContext sctx = this.DoGetServiceContext();
        //获取通行证
        Passport passport = this.passportRepository.GetPassportByLoginToken(loginToken, sctx);
        return passport != null ? passport.SID : null;
    }

    public Passport GetPassportByLoginToken(string loginToken)
    {
        ServiceContext sctx = this.DoGetServiceContext();
        //获取通行证
        Passport passport = this.passportRepository.GetPassportByLoginToken(loginToken, sctx);
        return passport;
    }

    /// <summary>
    /// 设置用户信息
    /// </summary>
    /// <param name="passportUser"></param>
    public void SetPassportUser(PassportUser passportUser)
    {
        ServiceContext sctx = this.DoGetServiceContext();
        //获取通行证
        Passport passport = this.passportRepository.GetPassportBySID(passportUser.PassportSID, sctx);
        if (passport == null)
        {
            throw new System.Exception("通行证不存在");
        }
        //设置用户信息
        passport.SetPassportUser(passportUser, this.dateTimeProvider);
        //保存通行证
        this.passportRepository.SavePassport(passport, sctx);
    }

    ///// <summary>
    ///// 添加证件
    ///// </summary>
    ///// <param name="passportID"></param>
    //public void AddPassportID(PassportID passportID)
    //{
    //    ServiceContext sctx = ServiceContext.Empty();
    //    List<PassportID> passportIDs = this.passportRepository.GetPassportIDsByPassportSID(passportID.PassportSID, sctx);
    //    passportID = new PassportIDList(passportIDs).AddPassportID(passportID);
    //    this.passportRepository.SavePassportID(passportID, sctx);
    //}

    ///// <summary>
    ///// 移除证件
    ///// </summary>
    ///// <param name="passportID"></param>
    //public void RemovePassportID(PassportID passportID)
    //{
    //    ServiceContext sctx = ServiceContext.Empty();
    //    this.passportRepository.DeletePassportIDByIDTypeNO(passportID.PassportSID, passportID.IDTypeNO, sctx);
    //}

    /// <summary>
    /// 设置用户名
    /// </summary>
    /// <param name="username"></param>
    public void SetUsername(PassportCredential passportCredential)
    {
        ServiceContext sctx = this.DoGetServiceContext();
        //验证用户名
        bool existsUsername = this.passportRepository.ExistsUsername(passportCredential.Username, sctx);
        if (existsUsername)
        {
            throw new System.Exception("用户名已存在");
        }
        //获取通行证
        Passport passport = this.passportRepository.GetPassportBySID(passportCredential.PassportSID, sctx);
        if (passport == null)
        {
            throw new System.Exception("通行证不存在");
        }
        //设置用户名
        passport.SetUsername(passportCredential.Username, this.dateTimeProvider);
        //保存通行证
        this.passportRepository.SavePassport(passport, sctx);
    }

    /// <summary>
    /// 设置手机
    /// </summary>
    /// <param name="passportCredential"></param>
    public void SetMobile(PassportCredential passportCredential)
    {
        //检查验证码
        string captcha_pre = this.textCaptchaLogService.PickCaptcha("_set_mobile", passportCredential.Mobile);
        if (!passportCredential.MatchMobileCaptcha(captcha_pre))
        {
            throw new System.Exception("验证码无效");
        }
        //
        ServiceContext sctx = this.DoGetServiceContext();
        //获取通行证
        Passport passport = this.passportRepository.GetPassportBySID(passportCredential.PassportSID, sctx);
        if (passport == null)
        {
            throw new System.Exception("通行证不存在");
        }
        //设置手机
        passport.SetMobile(passportCredential.Mobile, PassportCheckStateEnum.Checked, this.dateTimeProvider);
        //保存通行证
        this.passportRepository.SavePassport(passport, sctx);
    }

    /// <summary>
    /// 发送设置手机短信验证码
    /// </summary>
    /// <param name="mobile"></param>
    public void SendSmsCaptchaWithSetMobile(string mobile)
    {
        this.DoSendSmsCaptcha(mobile, "_set_mobile");
    }

    /// <summary>
    /// 设置邮箱
    /// </summary>
    /// <param name="passportCredential"></param>
    public void SetEmail(PassportCredential passportCredential)
    {
        //检查验证码
        string captcha_pre = this.textCaptchaLogService.PickCaptcha("_set_email", passportCredential.Email);
        if (!passportCredential.MatchEmailCaptcha(captcha_pre))
        {
            throw new System.Exception("验证码无效");
        }
        //
        ServiceContext sctx = this.DoGetServiceContext();
        //获取通行证
        Passport passport = this.passportRepository.GetPassportBySID(passportCredential.PassportSID, sctx);
        if (passport == null)
        {
            throw new System.Exception("通行证不存在");
        }
        //设置邮箱
        passport.SetEmail(passportCredential.Email, PassportCheckStateEnum.Checked, this.dateTimeProvider);
        //保存通行证
        this.passportRepository.SavePassport(passport, sctx);
    }

    /// <summary>
    /// 发送设置邮箱邮件验证码
    /// </summary>
    /// <param name="email"></param>
    public void SendEmailCaptchaWithSetEmail(string email)
    {
        this.DoSendEmailCaptcha(email, "_set_email");
    }

    /// <summary>
    /// 设置密码
    /// </summary>
    /// <param name="pwdOld"></param>
    /// <param name="pwdNew"></param>
    public void SetPassword(string passportSID, string pwdNew)
    {
        ServiceContext sctx = this.DoGetServiceContext();
        //获取通行证
        Passport passport = this.passportRepository.GetPassportBySID(passportSID, sctx);
        //设置新密码
        passport.SetPassword(pwdNew, this.dateTimeProvider);
        //保存通行证
        this.passportRepository.SavePassport(passport, sctx);
    }

        #endregion

        #region 授权管理

    public string GetLoginTokenByPassportAuthCode(
            string passportAuthCode,
            string categoryID)
    {
        ServiceContext sctx = this.DoGetServiceContext();
        var result = this.passportRepository.GetLoginTokenByPassportAuthCode(passportAuthCode, categoryID, sctx);
        return result;
    }

    public string GetPassportAuthCodeByLoginToken(
            string loginToken,
            string categoryID)
    {
        ServiceContext sctx = this.DoGetServiceContext();
        var result = this.passportRepository.GetPassportAuthCodeByLoginToken(loginToken, categoryID, sctx);
        return result;
    }

        #endregion
}
