package BackEnd.AccountManagement;

import java.util.ArrayList;
import java.util.Iterator;

public class AccountBUS {
    private ArrayList<Account> accountList = new ArrayList<>();
    private AccountDAO accountDAO = new AccountDAO();

    public AccountBUS() {
        accountList = accountDAO.getAllAccount();
    }

    public void readDB() {
        accountList = accountDAO.getAllAccount();
    }

    public ArrayList<Account> getAccountList() {
        return accountList;
    }

    public String getNextID() {
        String lastID = accountList.get(accountList.size() - 1).getUserId();
        String characterPart = lastID.substring(0, 2);
        int numberPart = Integer.parseInt(lastID.substring(2));
        numberPart++;
        String nextID = characterPart + String.format("%03d", numberPart);
        return nextID;
    }

    public Account getAccountById(String userId) {
        for (Account account : accountList) {
            if (account.getUserId().equals(userId)) {
                return account;
            }
        }
        return null;
    }

    public Boolean addAccount(Account account) {
        Boolean ok = accountDAO.addNewAccount(account);

        if (ok) {
            accountList.add(account);
        }
        return ok;
    }

    public void updateAccount(Account account) {
        Boolean ok = accountDAO.updateAccount(account);

        if (ok) {
            for (int i = 0; i < accountList.size(); i++) {
                if (accountList.get(i).getUserId().equals(account.getUserId())) {
                    accountList.set(i, account);
                    break;
                }
            }
        }
    }

    // public void deleteAccount(Account account) {
    // Boolean ok = accountDAO.deleteAccount(account);
    //
    // if (ok) {
    // for (int i = 0; i < accountList.size(); i++) {
    // if (accountList.get(i).getUserId().equals(account.getUserId())) {
    // accountList.remove(i);
    // break;
    // }
    // }
    // }
    // }
    public void deleteAccount(Account account) {
        // Kiểm tra tính hợp lệ của tham số đầu vào
        if (account == null) {
            return;
        }

        // Xóa tài khoản từ cơ sở dữ liệu
        Boolean ok = accountDAO.deleteAccount(account);

        // Kiểm tra kết quả từ phương thức deleteAccount
        if (ok != null && ok) {
            // Sử dụng Iterator để duyệt qua danh sách và xóa tài khoản
            Iterator<Account> iterator = accountList.iterator();
            while (iterator.hasNext()) {
                Account currentAccount = iterator.next();
                if (currentAccount.getUserId().equals(account.getUserId())) {
                    iterator.remove(); // Loại bỏ tài khoản một cách an toàn
                    break;
                }
            }
        }
    }

}
