$(function () {
    $('.form-control').each(function (index,element) {
        $(element).attr("autocomplete", "off")
    })
    $('.data-table').dynatable();
    $(".view-banner").on("click", function () {
        console.log("I am clicked")
        $('#imageModal').modal('toggle');
        $("#img").attr("src", $(this).attr("path"))
        $('#imageModal').modal('show');
        // $('#myModal').modal('hide');
    })
    $(".update-category").on("click", function (e) {
        var elem=$(this)
        var id = elem.attr("catid")
        var name =elem.attr("catname")
        var imagePath = elem.attr("imagepath")
        console.log(id,name,imagePath)
        $("#updateCategoryModal").find("input[name='id']").val(id);
        $("#updateCategoryModal").find("input[name='name']").val(name);
        // $("#updateCategoryModal").find("input[name='image']").val("/pojects/allora/"+imagePath);
        $("#updateCategoryModal").modal("toggle")
        $("#updateCategoryModal").modal("show")

    })
    $(".update-sub-category").on("click", function (e) {
        var elem=$(this)
        var id = elem.attr("catid")
        var name =elem.attr("catname")
        var imagePath = elem.attr("imagepath")
        var parentName = elem.attr("parentname")
        console.log(id,name,imagePath,parentName)
     $("#select").val(parentName).change()
        $("#updateSubCategoryModal").find("input[name='id']").val(id);
        $("#updateSubCategoryModal").find("input[name='name']").val(name);
        // $("#updateSubCategoryModal").find("select[name='category']").val(parentName);
        // $("#updateCategoryModal").find("input[name='image']").val("/pojects/allora/"+imagePath);
        $("#updateSubCategoryModal").modal("toggle")
        $("#updateSubCategoryModal").modal("show")

    })
});
$(function () {
    $(".delete-category").on('click', function () {
        var id = $(this).attr("id")
        console.log(id)

        if (confirm('Are you sure you want to delete this category?')) {
            $.ajax({
                url: "/adminPanel/deleteCategory/" + id,
                type: "POST",
                success: function (response) {
                    window.location.href = window.location.href
                },
                error: function (jqXHR, exception) {
                    console.log(jqXHR);
                    // Your error handling logic here..
                }
            });
        } else {
            // Do nothing!
            console.log('Thing was not saved to the database.');
        }


    })


})

