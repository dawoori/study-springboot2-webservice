var index = {
    init : funtion () {
        var_this = this;
        $('#btn-save').on('click', function() {
            _this.save();
        })
    }
    save : funtion () {
        var data = {
            titls: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        }
}
}