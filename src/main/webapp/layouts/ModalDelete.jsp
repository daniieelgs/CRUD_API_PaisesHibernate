    <div class="modal fade" id="modalDelete" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
            <h1 class="modal-title fs-5" id="exampleModalLabel">Eliminar Pais</h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <p>�Est� seguro de que desea eliminar el pa�s '<i><span class="country-name"></span></i>'?</p>
            </div>
            <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Tancar</button>
            <form class="form-delete" action="" method="POST" id="country-delete-form">

                <button type="submit" class="btn btn-danger btn-delete">Eliminar</button>
            </form>
            </div>
        </div>
        </div>
    </div>