const express = require('express');
const app = express();
const server = require('http').createServer(app);
const axios = require('axios');
path = require('path');

app.set('views', './views');
app.set('view engine', 'ejs');
app.use(express.static(path.join(__dirname, 'public')));

app.get('/', async (req, res) => {
    const token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6ImNsaWVudEBleGFtcGxlLmNvbSIsImlhdCI6MTYzMDU4Mjg2NSwiZXhwIjoxNjMzMTc0ODY1fQ.S30dYr3Ewo0vTUrCLe2Owmo7U7jl0HCq4-VHH0UK32U"
    const result = await axios({
        url : 'http://54.180.146.9:3001/client/user',
        headers : {Authorization : `Bearer ${token}`}
    })
    const data = result.data;
    console.log(data);
    res.render('mypage', {data});
})

app.get('/usepoint',(req, res) => {
    res.render('usepoint');
})

app.post('/login', async (req, res) => {
    const token = await axios({
        method : 'post',
        url : '54.180.146.9:3001/auth-non/login',
        data : {
            
        }
    });
    res.render()
})

app.get('/qrs', (req, res) => {
    console.log('who get in here/qrs');
    res.json(qrs);
})

app.post('/post', (req, res) => {
    console.log('who get in here post /qrs');
    var inputData;
    req.on('data', (data) => {
        inputData.json.parse(data);
    });
    req.on('end', () => {
        console.log('uid : ' + inputData.uid + ", point : " + inputData.point);
    });
    res.write("OK");
    res.render();
});

server.listen(3000, function() {
    console.log('server on..');
})

