const VEHICLES = {
    page: 0,
    size: 10,
    maxPage: 0,

}

const ORDERS = {
    page: 0,
    size: 10,
    maxPage: 0,

}
const VEHICLE_URL = "/vehicles";
const Order_URL = "/orders";

function findVehicles(trigger) {
    if (trigger != "page") VEHICLES.page = 0;
    fetch(VEHICLE_URL + "?" + new URLSearchParams({page:VEHICLES.page,size:VEHICLES.size}).toString())
        .then((e) => e.json())
        .then((data) => {
            console.log(data)
            let str = "";

            data.data.forEach(row => {
                str += `
                    <tr>
                        <th scope="row">${row.id}</th>
                        <td>${row.brand}</td>
                        <td>${row.model}</td>
                        <td>${row.year}</td>
                        <td>${row.mileage.toLocaleString('en-US', {minimumFractionDigits: 0})}</td>
                        <td>${row.used ? "Yes" : "No"}</td>
                        <td>${row.color}</td>
                        <td>${row.availability}</td>
                    </tr>
                `
            })

            VEHICLES.maxPage = data.extra.totalPages;
            document.querySelector("tbody").innerHTML = str;
            if (trigger != "page") {
                let pagesStr = "";
                for (let i = 0; i < data.extra.totalPages; i++) {
                    pagesStr += `
                  <option >${i + 1}</option>
                `
                }
                document.querySelector('.page').innerHTML = pagesStr
            }

        })


}
function next(back){
    let n = 1;
    if(back) n = -1;
    if(VEHICLES.page +n >= VEHICLES.maxPage || VEHICLES.page +n <0){
        alert("invalid");
        return;
    }
    VEHICLES.page = VEHICLES.page +n;
    findVehicles("page");
    document.querySelector('.page').value = `${VEHICLES.page+1}`;

}
function findOrders(trigger) {
    if (trigger != "page") ORDERS.page = 0;
    fetch(Order_URL + "?" + new URLSearchParams({page:ORDERS.page,size:ORDERS.size}).toString())
        .then((e) => e.json())
        .then((data) => {
            console.log(data)
            let str = "";

            data.data.forEach(row => {
                str += `
                    <tr>
                        <th scope="row">${row.id}</th>
                        <td>${row.brand}</td>
                        <td>${row.model}</td>
                        <td>${row.used ? "Yes" : "No"}</td>
                    </tr>
                `
            })

            ORDERS.maxPage = data.extra.totalPages;
            document.querySelector("tbody").innerHTML = str;
            if (trigger != "page") {
                let pagesStr = "";
                for (let i = 0; i < data.extra.totalPages; i++) {
                    pagesStr += `
                  <option >${i + 1}</option>
                `
                }
                document.querySelector('.page').innerHTML = pagesStr
            }

        })


}
function createOrder(e) {

    e.preventDefault();
    const data = {
        brand:document.querySelector("#order-brand")?.value,
        used:document.querySelector("#order-used")?.value,
        model:document.querySelector("#order-model")?.value
    }
    fetch(Order_URL , {
        body:JSON.stringify(data),
        method:"POST",
        headers: {
            'Content-Type': 'application/json'
        }
    })
        .then((e) => e.json())
        .then((data) => {
         alert("successful")

        })


}
function findVehiclesBrand() {

    fetch("/vehicles/brands")
        .then((e) => e.json())
        .then((data) => {

            let str = "<option>Brands</option>";

            data.data.forEach(row => {
                str += `
                   <option>${row}</option>
                `
            })


            document.querySelector("#order-brand").innerHTML = str;
        })


}
function findVehiclesBrandModel() {
const selected = document.querySelector("#order-brand").value;
    fetch("/vehicles/models/"+selected)
        .then((e) => e.json())
        .then((data) => {

            let str = "<option>Models</option>";

            data.data.forEach(row => {
                str += `
                   <option>${row}</option>
                `
            })


            document.querySelector("#order-model").innerHTML = str;
        })


}


if(window.location.pathname.match("index")) {
    findVehiclesBrand();

};
if(window.location.pathname.match("vehicle")) findVehicles();
if(window.location.pathname.match("order")) findOrders();


document.querySelector('.page')?.addEventListener('change', (e) => {
    VEHICLES.page = parseInt(e.target.value) - 1;
    if(window.location.pathname.match("vehicle"))findVehicles("page");
    else findOrders("page")
})
document.querySelector('.size')?.addEventListener('change', (e) => {
    VEHICLES.size = e.target.value;
    if(window.location.pathname.match("vehicle"))findVehicles("size");
    else findOrders("size")
})