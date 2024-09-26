function sortProducts(order) {
    window.location.href = "/Apple?sort=" + order;
}
fetch('/panier/add/1?utilisateurId=123', {
    method: 'POST'
})
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error('Error:', error));