function fetchRemoteUsers(callback){
    $.ajax({
        type : "GET",
        url : "/universityAdmin/getUsers",
        beforeSend : function(){

        },
        complete:function(){
        },
        success : function(users) {
            callback(users);
        },
        error : function(er) {

        }
    });
}

function fetchRemoteDataGeneric(url,callback){
    $.ajax({
        type : "GET",
        url : url,
        beforeSend : function(){

        },
        complete:function(){
        },
        success : function(users) {
            callback(users);
        },
        error : function(er) {

        }
    });
}

function fileUploadFunction(osId,resourceType,fd,callback,errorCallback){
    $.ajax({
        type: "POST",
        url: "/data/uploadFile/oricSession/"+osId+"/"+resourceType+"/",
        contentType: false,
        processData: false,
        cache: false,
        data: fd,
        beforeSend: function (xhr) {

        },
        success: function (response) {
            callback(response);
        },
        error : function(jqXHR, textStatus, errorThrown) {
            errorCallback(jqXHR, textStatus, errorThrown);
        }
    });
}
