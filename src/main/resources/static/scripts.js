let current;

const handleProductOpt = (number) => {
    current = products[number];

    $("#name").val(current.name);
    $("#brand").val(current.brand);
    $("#price").val(current.price.toFixed(2));
    $("#amount").val(current.amount);
    $("#width").val(current.width.toFixed(2));
    $("#height").val(current.height.toFixed(2));
    $("#depth").val(current.depth.toFixed(2));
    $("#weight").val(current.weight.toFixed(2));

    $("#create").prop("disabled", false);
    $("#update").prop("disabled", false);
    $("#delete").prop("disabled", false);
};

const onFieldInput = () => {
    $("#create").prop("disabled", false);
};

const createProduct = () => {
    disableActionButton();
    $.ajax({
        type: "POST",
        url: "/create",
        data: JSON.stringify(composeProduct()),
        headers: { 'Content-Type': 'application/json' }
    }).done(() => {
        reload();
    });
};

const updateProduct = () => {
    disableActionButton();

    const product = composeProduct();
    product.id = current.id;

    $.ajax({
        type: "POST",
        url: "/update",
        data: JSON.stringify(product),
        headers: { 'Content-Type': 'application/json' }
    }).done(() => {
        reload();
    });
};

const deleteProduct = () => {
    disableActionButton();
    $.get("/delete", { id: current.id }, () => reload());
};

const reload = () => {
    window.location.href = "/products";
};

const disableActionButton = () => {
    $("#create").prop("disabled", true);
    $("#update").prop("disabled", true);
    $("#delete").prop("disabled", true);
};

const composeProduct = () => {
    return {
        id : 0,
        name : $("#name").val(),
        brand : $("#brand").val(),
        price : $("#price").val(),
        amount : $("#amount").val(),
        width : $("#width").val(),
        height : $("#height").val(),
        depth : $("#depth").val(),
        weight : $("#weight").val(),
    };
};
