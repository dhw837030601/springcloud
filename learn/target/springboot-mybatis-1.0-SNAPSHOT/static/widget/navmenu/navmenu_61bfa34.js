define('widget/navmenu/navmenu', ['require', 'exports', 'module'], function(require, exports, module) {

  $(function() {
      $(".main-nav .menu-trigger").mouseenter(//当鼠标指针穿过元素时
          function() {
              $(".main-nav .ui-dropdown").slideUp();//使用滑动效果隐藏被选元素（下拉菜单）
              var target = $(this).data('target') + '-dropdown';//从元素中获取（data）被触发的元素(target)例如：23行product-dropdown
              $('#' + target).slideDown();//通过滑动效果显示被隐藏的效果
          }
      );
  
      $(".main-nav .ui-dropdown").mouseleave(//当鼠标离开时
          function() {
              $(this).slideUp();
          }
      );
  
  });
  

});