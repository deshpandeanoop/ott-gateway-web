function launchOttPlatform(platformType) {
    var ottPlatformUserId = sessionStorage.getItem("ottPlatformUserId");
    window.alert(ottPlatformUserId);

    $.get("http://localhost:9000/ott-gateway-service/v1/ottaccounts?gatewayUserId="+gatewayUserId+"&fetchOnlyNames=false&platformType=AMAZON_PRIME",
    function(data, status) {
        window.alert(data);
        window.alert(status);
    });
}