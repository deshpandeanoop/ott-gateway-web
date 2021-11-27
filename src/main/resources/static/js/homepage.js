$(document).ready(function(){
    showLogInForm();
});


function showRegistrationForm() {
    $('.register-info-box').fadeOut();
    $('.login-info-box').fadeIn();
    $('.white-panel').addClass('right-log');
    $('.register-show').addClass('show-log-panel');
    $('.login-show').removeClass('show-log-panel');
}

function showLogInForm() {
    $('.login-info-box').fadeOut();
    $('.register-info-box').fadeIn();

    $('.white-panel').removeClass('right-log');
    $('.login-show').addClass('show-log-panel');
    $('.register-show').removeClass('show-log-panel');
}