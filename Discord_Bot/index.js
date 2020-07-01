const Discord = require('discord.js');
const { prefix, token, giphyToken } = require('./config.json');
const bot =  new Discord.Client();

var GphApiClient = require('giphy-js-sdk-core')
giphy = GphApiClient(giphyToken)

bot.once('ready', () => {
    console.log('ready!')
})

bot.on('message', message => {
    if (message.member.hasPermission(['KICK_MEMBERS', 'BAN_MEMBERS'])) {

        if(message.content.startsWith(`${prefix}kick`)){
            let member = message.mentions.members.first();
            member.kick().then((member) => {

                giphy.search('gifs', {"q": "memes"})
                    .then((response) => {
                        var totalResponse = response.data.length;
                        var responseIndex = Math.floor((Math.random() *10) +1) % totalResponse;
                        var responseFinal = reponse.data[totalResponse];
                        message.channel.send("Goodbye " + member.displayName + ", u have served Mr.Chungus well!", {
                            files : [responseFinal.images.fixed_height.url]
                        })    
                    }).catch(() => {
                        message.channel.send('Error, Whoopsies!');
                    })


                
            })
        }
    } 
})

bot.login(token);