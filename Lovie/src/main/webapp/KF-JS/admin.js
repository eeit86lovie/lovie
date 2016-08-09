function openCategory() {
    $('#overlay').removeClass('hidden');
    $('.categories').removeClass('hidden').css('height', $(window).height() + "px");
}
function closeCategory() {
    $('.categories').addClass('hidden');
    $('#overlay').addClass('hidden');
}

function redirect_to(url) {
    window.location.href = url;
}

function open_newTab(url) {
    var win = window.open(url, '_blank');
    win.focus();
}
function reloadPage() {
    window.location.reload();
}


function process_msg(place, msg) {
    $(place + ' .button_box').addClass('hidden');
    $(place + ' .err_msg_div').addClass('hidden');
    $(place + ' .process_msg_div').removeClass('hidden');
    $(place + ' .process_msg').text(msg);
}
function error_msg(place, msg) {
    $(place + ' .button_box').removeClass('hidden');
    $(place + ' .process_msg_div').addClass('hidden');
    $(place + ' .err_msg_div').removeClass('hidden');
    $(place + ' .err_msg').text(msg);
}

function changeChatStatus(item) {
    var data = $(item).attr("data-show");
    if (data == "NO") {
        $(item).removeClass("switch_off").addClass("switch_on");
        $(item).attr("data-show", "YES");
        var status = "YES";
    } else if (data == "YES") {
        $(item).removeClass("switch_on").addClass("switch_off");
        $(item).attr("data-show", "NO");
        var status = "NO";
    }
    $.post(site_url + "/chat/changeChatStatus", { status: status }, function (data) {
        if (data.status == "OK") {

        } else {

        }
    }, 'json');

}