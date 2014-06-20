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