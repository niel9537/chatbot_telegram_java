/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatelegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import javax.swing.JComponent;

/**
 *
 * @author User
 */
public class MyProjectHandler extends TelegramLongPollingBot {

    public MyProjectHandler() {
    }
    public void sendPesan (String id, String pesan) {
        SendMessage sendMessageRequest = new SendMessage();
        sendMessageRequest.setChatId(id);
        sendMessageRequest.setText(pesan);
        try {
            sendMessage(sendMessageRequest);
        } catch (TelegramApiException e) {
            
        }
    }
    //fungsi sendPesan untuk reply chat pengguna bot
    @Override
    public String getBotToken() {
       return BotConfig.TOKENMYPROJECT;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage()) {
            Message message = update.getMessage();
            if(message.hasText()) {
                String pesanM = message.getChatId().toString()+ " : " + message.getText() + "";
                frmTelegram.LstPesan.add(pesanM);
               // frmTelegram.LstPesan.add(pesanM);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return BotConfig.USERNAMEMYPROJECT;
    }
    
}
