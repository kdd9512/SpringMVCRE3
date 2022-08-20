<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../includes/header.jsp" %>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Board Read</h1>
    </div>
</div>
<%--/.row--%>

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">

            <div class="panel-heading">Board Read Page</div>
            <div class="panel-body">

                <div class="form-group">
                    <label>Bno</label>
                    <input class="form-control" name="bno"
                           value="<c:out value="${board.bno}"/>" readonly="readonly">
                </div>

                <div class="form-group">
                    <label>Title</label>
                    <input class="form-control" name="title"
                           value="<c:out value="${board.title}" />" readonly="readonly">
                </div>

                <div class="form-group">
                    <label>Text Area</label>
                    <input class="form-control" name="content"
                           value="<c:out value="${board.content}" />" readonly="readonly">
                </div>

                <div class="form-group">
                    <label>Writer</label>
                    <input class="form-control" name="writer"
                           value="<c:out value="${board.writer}" />" readonly="readonly">
                </div>

                <button data-oper="modify" class="btn btn-default"
                onclick="location.href='/board/modify?bno=<c:out value="${board.bno}"/>'">MODIFY</button>
                <button data-oper="list" class="btn btn-info"
                onclick="location.href='/board/list'">LIST</button>

                <form id="operForm" action="/board/modify" method="get">
                    <input type="hidden" id="bno" name="bno" value="<c:out value="${board.bno}"/>"/>
                    <%-- 전송된 Criteria 의 값을 받아 보관하고, 타 페이지로 전송한다. --%>
                    <input type="hidden" name="pageNum" value="<c:out value="${cri.pageNum}"/>"/>
                    <input type="hidden" name="amount" value="<c:out value="${cri.amount}"/>"/>
                    <%-- 검색기준이 적용되어 결과를 낸 리스트 -> 조회페이지 -> 검색기준이 적용되어 결과를 낸 리스트  --%>
                    <input type="hidden" name="keyword" value="<c:out value="${cri.keyword}"/>"/>
                    <input type="hidden" name="type" value="<c:out value="${cri.type}"/>"/>
                </form>

            </div>
            <%-- panel-body --%>
        </div>
        <%-- panel-body --%>
    </div>
    <%-- panel --%>
</div>
<%-- /.row --%>

<script type="text/javascript" src="/resources/js/reply.js"></script>
<script>

    // bno 값
    let bnoValue = '<c:out value="${board.bno}"/>';

    // replyService.add() 테스트용.
    <%-- replyService.add(
            {reply: "TEST REPL", replier: "TEST REPLIER", bno: bnoValue},
            function (result) {
                 alert("RESULT : " + result);
            }
        ); 
     --%>
    
    // 현재 열람중인 get 페이지가 가지고 있는 댓글 목록을 console 에 출력한다. 
    replyService.getList({bno: bnoValue, page:1}, function(list) {

        for(let i=0, len = list.length||0; i<len; i++) {
            console.log(list[i]);
        }

    })

    // 첫 번째 param 과 같은 rno 를 가진 댓글을 삭제한다.
    <%-- replyService.remove(9, function (cnt) {
        console.log(cnt);

        if (cnt == "success") {
            alert("삭제되었습니다");
        }
    }, function (err) {
        alert("ERROR........");
    }); --%>
    
</script>

<script type="text/javascript">
    $(document).ready(function () {

       let operForm = $("#operForm");

       $("button[data-oper='modify']").on("click", function (e) {

           operForm.attr("action", "/board/modify").submit();

       });

       $("button[data-oper='list']").on("click", function() {

           operForm.find("#bno").remove();
           operForm.attr("action", "/board/list");
           operForm.submit();

        });

    });
</script>
<%@ include file="../includes/footer.jsp" %>