const websocket = new WebSocket("ws://localhost:9000/greg")

websocket.addEventListener('open', () => {
    setInterval(() => {
        websocket.send('')
    }, 30000)
})

document.getElementById('sendMessage').addEventListener('click', () => {
    const wsMessage = window.prompt('Enter your message')
    websocket.send(wsMessage)
})

websocket.onmessage = (e) => {
    console.log(e.data)
}
