var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
        $('#btn-update').on('click', function () {
            _this.update();
        });
        $('#btn-delete').on('click', function () {
            _this.delete();
        });
    },
    save : function () {
        var data = {
            id: $('#id').val(),
            name: $('#name').val(),
            pass: $('#pass').val(),
            email: $('#email').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/members',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('정보가 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update : function () {
         var data = {
            id: $('#id').val(),
            name: $('#name').val(),
            pass: $('#pass').val(),
            email: $('#email').val()
         };

         var num = $('#num').val();

         $.ajax({
              type: 'PUT',
              url: '/api/v1/members/' + num,
              dataType: 'json',
              contentType: 'application/json; charset=utf-8',
              data: JSON.stringify(data)
         }).done(function() {
              alert('정보가 수정되었습니다.');
              window.location.href = '/';
         }).fail(function (error){
             alert(JSON.stringify(error));
         });
    },
    delete : function () {
          var num = $('#num').val();

          $.ajax({
              type: 'DELETE',
              url: '/api/v1/members/' + num,
              dataType: 'json',
              contentType:'application/json; charset=utf-8'
          }).done(function() {
              alert('정보가 삭제되었습니다.');
              window.location.href ='/';
          }).fail(function (error){
              alert(JSON.stringify(error));
          });
    }


};

main.init();