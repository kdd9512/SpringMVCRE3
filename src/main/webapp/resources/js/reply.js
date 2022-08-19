console.log("Reply Module Test-------------------------------");

let replyService = (function () {

    function add(reply, callback, error) {
        console.log("add reply--------------------------------------");

        $.ajax({
            type: "POST",
            url: "/replies/new",
            data: JSON.stringify(reply),
            contentType: "application/json; charset=utf-8",
            success: function (result, status, xhr) {
                if (callback) {
                    callback(result);
                }
            },
            error: function (xhr, status, err) {
                if (error) {
                    error(err);
                }
            }
        })
    }
    return {
        add: add
    };
})();