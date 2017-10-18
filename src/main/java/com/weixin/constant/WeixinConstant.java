package com.weixin.constant;

public interface WeixinConstant {
	String IN_Encrypt = "Encrypt";
	String WX_ENCODINGAESKEY = "encodingaeskey";
	String SHA1 = "SHA-1";
	String WX_PARAM_TOKEN = "token";
	String WX_PARAM_APPID = "appid";
	String WX_PARAM_SCERET = "secret";
	String GETACCESS_TOKENURL = "getAccess_tokenURL";
	String SERVER = "server";
	String PHPSERVER = "phpserver";
	String WX_UTF8 = "UTF-8";
	String NOTNEED_CDATA_1 = "CreateTime";
	String NOTNEED_CDATA_2 = "MsgId";
	String NOTNEED_CDATA_3 = "Location_X";
	String NOTNEED_CDATA_4 = "Location_Y";
	String NOTNEED_CDATA_5 = "Scale";

	String WX_MESSAGETYPE_TEXT = "text"; // 文本消息
	String WX_MESSAGETYPE_IMAGE = "image"; // 图片消息
	String WX_MESSAGETYPE_VOICE = "voice"; // 语音消息
	String WX_MESSAGETYPE_VIDEO = "video"; // 视频消息
	String WX_MESSAGETYPE_NEWS = "news"; // 视频消息
	String WX_MESSAGETYPE_SHORTVIDEO = "shortvideo"; // 小视频消息
	String WX_MESSAGETYPE_LOCATION = "location"; // 地理位置消息
	String WX_MESSAGETYPE_LINK = "link"; // 地理位置消息
	String WX_MESSAGETYPE_EVENT = "event"; // 事件

	String IN_COMM_ToUserName = "ToUserName";
	String IN_COMM_FromUserName = "FromUserName";
	String IN_COMM_CreateTime = "CreateTime";
	String IN_COMM_MsgType = "MsgType";
	String IN_COMM_EventKey = "EventKey";
	String IN_COMM_Event = "Event";
	String IN_COMM_MsgId = "MsgId";

	String EVENT_XML_EventKey = "EventKey";
	String EVENT_XML_Ticket = "Ticket";
	String EVENT_SUBSCRIBE = "subscribe";
	String EVENT_UNSUBSCRIBE = "unsubscribe";
	String EVENT_SUBSCRIBE_qrscene = "qrscene_";
	String EVENT_SCAN = "SCAN";
	String EVENT_CLICK = "CLICK";
	String IN_TEXT_Content = "Content";

	String IN_IMAGE_PICURL = "PicUrl";

	String IN_COMMON_MEDIAID = "MediaId";
	String IN_COMMON_FORMAT = "Format";
	String IN_COMMON_THUMBMEDIAID = "ThumbMediaId";
	String IN_VOICE_RECOGNITION = "Recognition";
	String IN_LOCATION_LABEL = "Label";

	String IN_LINK_TITLE = "Title";
	String IN_LINK_DESCRIPTION = "Description";
	String IN_LINK_URL = "Url";
	////////// 授权
	String sq_scope_snsapi_base = "snsapi_base";
	String sq_scope_snsapi_userinfo = "snsapi_userinfo";
	String sq_getCodeURL = "sq_getCodeURL";
	String sq_getAccessTokenByCodeURL = "sq_getAccessTokenByCodeURL";
	String sq_getUserInfo = "sq_getUserInfo";
	/// 二维码
	String ewm_getTicketURL = "ewm_getTicketURL";

	String ewm_QR_SCENE = "QR_SCENE";
	String ewm_QR_LIMIT_SCENE = "QR_LIMIT_SCENE";
	String ewm_QR_LIMIT_STR_SCENE = "QR_LIMIT_STR_SCENE";
	String ewm_getEWMByTicket = "getEWMByTicket";
	///////////////
	String ssdk_getJsapiTicketURL = "getJsapiTicketURL";
	///// 获取多媒体
	String file_getDuoMeiTiURL = "getDuoMeiTiURL";
	String MEDIA_TYPE_audio_amr = "audio/amr";
	// 创建菜单
	String createMenuBT = "createMenuBT";
	// 获取按钮列表
	String getMunuBT = "getMunuBT";
	////
	String getUserInfoByOpenId = "getUserInfoByOpenId";
}
