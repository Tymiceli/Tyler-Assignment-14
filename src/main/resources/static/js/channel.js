let messageBox = document.querySelector("#message-box")
setInterval(getMessages, 500)

let id = document.querySelector('textarea[data-id]')
let channelId = id.getAttribute('data-id')
let user = JSON.parse(sessionStorage.getItem('user'))

messageBox.addEventListener('keydown', (e) => {
    if (e.key === 'Enter') {
        var message = {
            "channelId": channelId,
            "contents": messageBox.value,
            "user": user
        }
        e.preventDefault();
        messageBox.value ='';
        fetch(`http://localhost:8080/messages`,
            {
                method: "POST",
                headers:
                {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(message)
            })
            .then(response => response.json())
            .then(data => {
                console.log(data)
            })
    }
})

function getMessages() {
    let messageArea = document.querySelector("#messages")
    fetch(`http://localhost:8080/messages/${channelId}`)
        .then(response => response.json())
        .then(data => {
            messageArea.innerHTML = ''
            data.forEach(message => {
                messageArea.innerHTML += `<div>
			  <span>${message.user.name}: ${message.contents}</span>
			</div>`
            })
        })
}
