$.fn.serializeObject = function() {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [ o[this.name] ];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
}
/**
 * 表单通用赋值
 * @param form
 * @param jsonValue
 */
function initFormData(form, jsonValue) {
    if (!$.isEmptyObject(jsonValue)) {

        $.each(jsonValue, function (key, value) {
            var formField = form.find("[name='"+key+"']");
            if($.type(formField[0]) === "undefined"){
               console.log("name="+key+" is not exsit!");
            } else{
                var fieldTagName = formField[0].tagName.toLowerCase();
                if(fieldTagName == "input"){
                    if(formField.attr("type") == "radio"){
                        $("input:radio[name='"+key+"'][value='"+value+"']").attr("checked","checked");
                    } else {
                        formField.val(value);
                    }
                } else if(fieldTagName == "select"){
                    //do something special
                    formField.val(value);
                } else if(fieldTagName == "textarea"){
                    //do something special
                    formField.val(value);
                } else {
                    formField.val(value);
                }
            }

         });

    }
}
