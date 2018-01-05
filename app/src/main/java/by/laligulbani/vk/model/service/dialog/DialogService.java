package by.laligulbani.vk.model.service.dialog;

import java.util.List;

import by.laligulbani.vk.Api;
import by.laligulbani.vk.entity.messages.Dialog;
import by.laligulbani.vk.entity.messages.DialogResponse;
import by.laligulbani.vk.model.client.IClient;
import by.laligulbani.vk.model.db.IDataBase;
import by.laligulbani.vk.model.parser.IParser;
import by.laligulbani.vk.model.service.AbstractService;

public class DialogService extends AbstractService implements IDialogService {

    private final IDataBase dataBase;

    DialogService(final IClient client,
                  final IParser parser,
                  final IDataBase dataBase) {
        super(parser, client);
        this.dataBase = dataBase;
    }

    @Override
    public List<Dialog> getDialogs(final String token) {

        if (checkInternetConnection()) {

            final Dialog last = dataBase.getLastDialog();

            final String sb = Api.DIALOGS_GET
                    + "?"
                    + "access_token=" + token
                    + "&"
                    + "count=100";

       //     if (last != null && last.getId() != null) {
//                sb.append("&").append("unread=0");
      //      }

            final List<Dialog> dialogs = execute(sb, DialogResponse.class).getDialogs();
            dataBase.addDialogs(dialogs);
        }

        return dataBase.getDialogs();
    }
}

