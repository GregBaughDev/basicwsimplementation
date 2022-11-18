const websocket = new WebSocket("ws://localhost:8887")

websocket.addEventListener('open', () => {
    websocket.send('Client connected')
})

document.getElementById('sendMessage').addEventListener('click', () => {
    const wsMessage = window.prompt('Enter your message')
    websocket.send(wsMessage)
})

websocket.onmessage = (e) => {
    document.getElementById('receivedMessage').textContent = e.data
}