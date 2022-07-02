const Toast = Swal.mixin({
    toast: true,
    position: 'top-end',
    showConfirmButton: false,
    timer: 3000,
    timerProgressBar: true,
    onOpen: (toast) => {
        toast.addEventListener('mouseenter', Swal.stopTimer)
        toast.addEventListener('mouseleave', Swal.resumeTimer)
    }
})


function populateListUsers(lists,users,selected,lamb){
    let sel = "";
    users.forEach(function(v){
        if(selected){
            sel = "selected";
            selected = false;
        }
        else{
            sel = "";
        }
        let option = "<option value='"+v.id+"' "+sel+">"+lamb(v)+"</option>";
        lists.forEach(function(list){

            $('#'+list).append(option);
        })

    });
}

function updateRowInTable($table,data){
    let r =  $table.bootstrapTable('getRowByUniqueId', parseInt(data.id));
    if(r == null)
        $table.bootstrapTable('insertRow', {index: 0, row: data});
    else {
        $table.bootstrapTable('updateByUniqueId', {id: data.id, row: data})
    }
}

function getShowFileURLResearch(){
    return "/data/openFileResearch/oricSession/"+$("#oricSessionId").val()+"/type/"+$("#typeId").val()+"/research/"+$("#researchId").val()+"/file/";
}

function getDeleteFileURLResearch(){
    return "/data/deleteFileResearch/oricSession/"+$("#oricSessionId").val()+"/type/"+$("#typeId").val()+"/research/"+$("#researchId").val()+"/file/";
}

function assignIfNotEmpty(obj,field,val){
    let piVal = obj[field];
    if(piVal != null && typeof piVal !== 'undefined'&& piVal != 0 && piVal != '')
        $('#'+field).val(obj[field]);
}

function getShowUrlOfResource(sessionId,type){
    return "/oricAdmin/oricSession/"+sessionId+"/showResource/"+type;
}

