const navbar = `
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand btn btn-primary btn-lg animate__animated animate__zoomIn" href="/">Welcome to Bobby cars</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="btn btn-outline-warning nav-link" href="/">Home</a>
      </li>&emsp;
      <li class="nav-item">
        <a class="btn btn-outline-success nav-link" href="/vehicles.html">Vehicles</a>
      </li>&emsp;
      <li class="nav-item">
        <a class="nav-link btn btn-outline-secondary" href="/orders.html">Orders</a>
      </li>

    </ul>
  </div>
</nav>

`

document.querySelector("#navbar").innerHTML = navbar;