define('static/widget/backtotop/backtotop', ['require', 'exports', 'module'], function(require, exports, module) {

  $(document).ready(function () {
      if (($(window).height() + 100) < $(document).height()) {
          $('#top-affix').removeClass('hidden').affix({
              offset: {
                  top: 100
              }
          });
      }
  });
  

});