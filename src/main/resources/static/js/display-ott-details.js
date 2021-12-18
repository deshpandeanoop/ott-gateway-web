function launchOttPlatform(platformType) {
    var ottPlatformUserId = sessionStorage.getItem("ottPlatformUserId");

    if(platformType == 'AMAZON_PRIME') {
       var amazonPrimeLaunchUrl = 'https://www.amazon.com/ap/signin?accountStatusPolicy=P1&clientContext=261-8397475-8223164&language=en_US&openid.assoc_handle=amzn_prime_video_desktop_us&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.primevideo.com%2Fauth%2Freturn%2Fref%3Dav_auth_ap%3F_encoding%3DUTF8%26location%3D%252Fref%253Ddv_auth_ret'
       var amazonWindow = window.open(amazonPrimeLaunchUrl + '&platformType='+platformType + '&ottPlatformUserId='+ottPlatformUserId);
       } else if(platformType == 'NETFLIX') {
          window.open('https://www.netflix.com/in/login');
     }
}