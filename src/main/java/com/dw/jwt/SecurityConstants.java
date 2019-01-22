package com.dw.jwt;

/**
 * @author liweicheng
 * @ProjectName gaofenshuo-parent
 * @Package com.gaofenshuo.security.base.properties
 * @ClassName SecurityConstants
 * @description 静态定义
 * @date created in 2018-07-30 17:57
 * @modified by
 */
public class SecurityConstants {

	/**
	 * 默认的处理验证码的url前缀
	 */
	public static final String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/api/secuity/code";
	/**
	 * 当请求需要身份认证时，默认跳转的url
	 */
	public static final String DEFAULT_UNAUTHENTICATION_URL = "/api/secuity/require";
	/**
	 * 默认的用户名密码登录请求处理url
	 */
	public static final String DEFAULT_LOGIN_PROCESSING_URL_FORM = "/api/secuity/form";
	/**
	 * 默认的手机验证码登录请求处理url
	 */
	public static final String DEFAULT_LOGIN_PROCESSING_URL_MOBILE = "/api/secuity/mobile";
	/**
	 * 默认登录页面
	 * /spring-secuity-login.html
	 */
	public static final String DEFAULT_LOGIN_PAGE_URL = "/admin/login";
	/**
	 * 验证图片验证码时，http请求中默认的携带图片验证码信息的参数的名称
	 */
	public static final String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "imageCode";
	/**
	 * 验证短信验证码时，http请求中默认的携带短信验证码信息的参数的名称
	 */
	public static final String DEFAULT_PARAMETER_NAME_CODE_SMS = "smsCode";
	/**
	 * 发送短信验证码 或 验证短信验证码时，传递手机号的参数的名称
	 */
	public static final String DEFAULT_PARAMETER_NAME_MOBILE = "mobile";
	/**
	 * 默认的处理登录文件的url前缀
	 */
	public static final String DEFAULT_VALIDATE_HTML_URL_SUFFIX = ".html";
	/**
	 * 默认登录页面
	 */
	public static final String DEFAULT_LOGIN_ERROR_URL = "/error.html";

	/**
	 * v2/api-docs
	 */
	public static final String DEFAULT_SWAGGER_V2_API_DOCS_URL = "/v2/api-docs";
	/**
	 * swagger-ui.html
	 */
	public static final String DEFAULT_SWAGGER_UI_URL = "/swagger-ui.html";
	/**
	 * swagger-resources
	 */
	public static final String DEFAULT_SWAGGER_RESOURCES_URL = "/swagger-resources/**";
	/**
	 * /images/**
	 */
	public static final String DEFAULT_SWAGGER_IMAGES_URL = "/images/**";
	/**
	 * /images/**
	 */
	public static final String DEFAULT_SWAGGER_WEBJARS_URL = "/webjars/**";
	/**
	 * /configuration/ui
	 */
	public static final String DEFAULT_SWAGGER_CONFIGURATION_UI_URL = "/configuration/ui";
	/**
	 * /configuration/security
	 */
	public static final String DEFAULT_SWAGGER_CONFIGURATION_SECURITY_URL = "/configuration/security";
	
	public  static final String DEFAULT_VALIDATE_HTML_JS_SUFFIX = "/**/js/**";

	public  static final String DEFAULT_VALIDATE_HTML_FONTS_SUFFIX = "/**/fonts/**";

	public  static final String DEFAULT_VALIDATE_HTML_CSS_SUFFIX = "/**/css/**";

	public  static final String DEFAULT_VALIDATE_HTML_IMAGES_SUFFIX = "/**/images/**";

}
