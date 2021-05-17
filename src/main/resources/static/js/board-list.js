var SELECTED_CLASS = "is-current";

function onPageClick(idx) {}

function setSelected() {
  var curPageIndexBtn = `#page-btn-${currentPageIndex}`;
  var curPage = $(curPageIndexBtn);
  curPage.addClass(SELECTED_CLASS);
}

function disableNonValid() {
  console.log(prev, next, currentPageIndex);
  $(".pagination-previous").attr("disabled", !prev);
  $(".pagination-next").attr("disabled", !next);
}

$(function () {
  setSelected();
  disableNonValid();
});
