





document.getElementById('img').addEventListener('change', function () {
    var reader = new FileReader();
    reader.onload = function (e) {
    	var res=reader.result;
    	var fileSize=1;
        compress(res,fileSize);
    };
    reader.readAsDataURL(this.files[0]);
    console.log(this.files[0]);
    var fileSize = Math.round( this.files[0].size/1024/1024) ; // 以M为单位
}, false);

