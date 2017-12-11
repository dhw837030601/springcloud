define('widget/header/header', ['require', 'exports', 'module'], function(require, exports, module) {

  $(function () {
      $(".nav li").hover(
          function () {
              $(this).find("ul").show(100);
              $(this).addClass("current");
          },
          function () {
              $(this).find("ul").hide();
              $(this).removeClass("current");
          }
      );
  
      $(".navMain .dorpdown").hover(
          function () {
              $(this).find("ul").show(100);
              $(this).addClass("current");
          },
          function () {
              $(this).find("ul").hide();
              $(this).removeClass("current");
          }
      );
  
      $(".container").on('click', '#logoutIndex', function () {
          $.ajax({
              url: window.__profix__ + 'user/logout.json',
              type: 'POST',
              dataType: 'json',
              data: {}
          })
              .done(function (data) {
                  if (data && data.code == 0) {
                      location.reload();
                  }
              })
              .fail(function () {
                  console.log("error");
              });
      });
  
  });

});