// $(document).ready(function () {
//     $('#program-table').DataTable({ //selector tag tables
//         ajax: {
//             url: 'api/program',// mengacu pada endpoint yg mengembalikan data dlm bntuk Json (buat RestController di ApiRegionControl)
//             dataSrc: '' // kalau punya objek di dalam objek(select objek di dalam objek)// datasrc wajib ditulis
//         },
//         columns: [{// mengacu pada data atribut di dalam table
//                 data: 'id'
//             },
//             {
//                 data: 'name'
//             },
//             {
//                 data: 'description'
//             },
//             {
//                 "data": null, // buat sebagai action // coba lihat di region/indek.html line 47-49
//                 render: function (data, row, type, meta) {
//                     return `
//                     <button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#updateprogram"
//                         onclick="beforeUpdate(${data.id})">
//                         <i class="bi bi-pencil-square"></i>
//                     </button>
//                     <button type="button" class="btn btn-danger"
//                         onclick="regionDelete(${data.id})">
//                         <i class="bi bi-trash3-fill"></i>
//                     </button>

//                     `;
//                 }
//             }
//         ]
//     });
// });

function create() {
    let valName = $('#program-in-name').val();
    let valDesc = $('#program-in-description').val();
    $.ajax({
        method: "POST",
        url: "api/program",
        dataType: "JSON",
        beforeSend: addCsrfToken(),
        data: JSON.stringify({
            name: valName,
            description: valDesc
        }),
        contentType: "application/json",
        success: result => {
            console.log(result)
            $('#addprogram').modal('hide')
            window.reload();
            //$('#program-table').DataTable().ajax.reload()
            // Swal.fire({
            //     position: 'center',
            //     icon: 'success',
            //     title: 'Successfully to insert',
            //     showConfirmButton: false,
            //     timer: 2000
            // })
        },
        error: (result) => {
            console.log(result)
            // Swal.fire({
            //     icon: 'error',
            //     title: 'Oops... Something went wrong!',
            //     text: 'Please check the input fields, make sure nothing is empty!'
            // })
        }
    })
}


function beforeUpdate(id) {
    $.ajax({
        method: "GET",
        url: "api/program/" + id,
        dataType: "JSON",
        success: function (result) {
            $('#program-up-id').val(`${result.id}`)
            $('#program-up-name').val(`${result.name}`)
            $('#program-up-description').val(`${result.description}`)
        }
    })
}

function update() {
    let valId = $('#program-up-id').val()
    let valName = $('#program-up-name').val()
    let valDesc = $('#program-up-description').val()

    Swal.fire({
        title: 'Are you sure?',
        text: "Do you want to change this region!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                method: "PUT",
                url: "api/program/" + valId,
                dataType: "JSON",
                beforeSend: addCsrfToken(),
                contentType: "application/json",
                data: JSON.stringify({
                    name: valName,
                    description: valDesc
                }),
                success: result => {
                    $('#updateprogram').modal('hide')
                    $('#program-table').DataTable().ajax.reload()
                    Swal.fire({
                        position: 'center',
                        icon: 'success',
                        title: 'Successfully to update',
                        showConfirmButton: false,
                        timer: 2000
                    })
                },
                error: (result) => {
                    console.log(result)
                    Swal.fire({
                        icon: 'error',
                        title: 'Oops... Something went wrong!',
                        text: 'Please check the input fields, make sure nothing is empty!'
                    })
                }
            })
        }
    })
}

function programDelete(id) {

    Swal.fire({
        title: 'Are you sure?',
        text: "You won't be delete this region!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                method: "DELETE",
                url: "api/program/" + id,
                dataType: "JSON",
                beforeSend: addCsrfToken(),
                success: result => {
                    $('#program-table').DataTable().ajax.reload()
                    // Swal.fire({
                    //     title: 'Successfully to Delete',
                    //     width: 600,
                    //     padding: '3em',
                    //     color: '#716add',
                    //     background: '#fff',
                    //     backdrop: `
                    //         rgba(0,0,123,0.4)
                    //         url("https://media.tenor.com/1Nc6rtScQEUAAAAM/thats-it-yes-thats-it.gif")
                    //         left top
                    //         no-repeat
                    //     `,
                    //     icon: 'success',
                    //     showConfirmButton: false,
                    //     timer: 5000
                    // })
                }
            })
        }
    })

}