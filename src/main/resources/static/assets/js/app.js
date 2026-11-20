
const menuButton = document.getElementById("menuButton");
const navLinks = document.getElementById("navLinks");

menuButton.addEventListener("click", function () {
    navLinks.classList.toggle("active");
});

const productGrid = document.getElementById("productGrid");


async function loadProducts() {

    try {

        const response = await fetch("http://localhost:8080/product/all");

        const products = await response.json();

        let productHTML = "";

        products.forEach(product => {

            productHTML += `
                <div class="product-card">

                    <img src="${product.imageUrl}" alt="${product.name}">

                    <h4>${product.name}</h4>

                    <h5>Rs. ${product.price}</h5>

                    <p>${product.description}</p>

                    <button>Add to cart</button>

                </div>
            `;

        });

        productGrid.innerHTML = productHTML;

    } catch (error) {

        console.error("Error loading products:", error);

        productGrid.textContent = "Unable to load products.";

    }

}

loadProducts();
