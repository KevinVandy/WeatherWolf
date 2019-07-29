<div id="flashparent">
  <g:if test="${flash.error}">
    <p class="alert-danger all-center p m" id="flashmsg">${flash.error}</p>
  </g:if>
  <g:elseif test="${flash.warning}">
    <p class="alert-warning all-center p m " id="flashmsg">${flash.warning}</p>
  </g:elseif>
  <g:elseif test="${flash.success}">
    <p class="alert-success all-center p m" id="flashmsg">${flash.success}</p>
  </g:elseif>
</div>

<script>
    setTimeout(() => {
        $('#flashparent').fadeOut(4500);
        $('#flashmsg').slideUp(5000);
    }, 20000)
</script>