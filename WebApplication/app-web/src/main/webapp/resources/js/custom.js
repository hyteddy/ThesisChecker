/*
 * author: Toamsz Morek
 * File with custom javascript method use in all project
 */

$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

function showErrors(data) {
    $("#errorMessage").text(data.errorMessage);
    $("#errorMessage").show();
    for (var i = 0; i < data.errors.length; i++) {
        var error = data.errors[i];
        var formGroup = $("#" + error.code + "Group");
        formGroup.find(".validMessage").html(error.defaultMessage);
        formGroup.addClass("has-error");
    }
}

function removeErrors() {
    $("#errorMessage").hide();
    $(".form-group").removeClass("has-error");
    $(".validMessage").text("");
}

function removeInfo() {
    $("#infoMessage").hide();
}

function formatDate(timestamp) {
    var date = new Date(timestamp);
    var day = date.getDate();
    if (day < 10) {
        day = "0" + day;
    }
    var month = date.getMonth() + 1;
    if (month < 10) {
        month = "0" + month;
    }
    var year = date.getFullYear();
    var hours = date.getHours();
    if (hours < 10) {
        hours = "0" + hours;
    }
    var minutes = date.getMinutes();
    if (minutes < 10) {
        minutes = "0" + minutes;
    }
    var seconds = date.getSeconds();
    if (seconds < 10) {
        seconds = "0" + seconds;
    }
    return year + "-" + month + "-" + day + " " + hours + ":" + minutes + ":" + seconds;
}