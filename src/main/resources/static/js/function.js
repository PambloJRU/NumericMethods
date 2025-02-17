async function fetchRandomImage() {
    try {
        // Configura los headers necesarios para la autenticación
        const headers = new Headers({
            'Accept': 'application/json'
        });

        const response = await fetch("https://danbooru.donmai.us/posts/random.json?tags=zenless_zone_zero", {
            method: 'GET',
            headers: headers,
            credentials: 'omit'
			//"is:sfw" cat_girl
			//"+rating:safe"
        });

        if (response.ok) {
            const data = await response.json();
            const imageUrl = data.file_url;
            if (imageUrl) {
                const imageElement = document.getElementById("random-image");
                imageElement.src = imageUrl;
                imageElement.style.display = "block";

                // Espera un momento para asegurarse de que la imagen se muestre
                await new Promise(resolve => setTimeout(resolve, 500));
            }
        }
    
    } catch (error) {
        console.error("Error:", error);
        alert("Error al cargar la imagen: " + error.message);
    }
}