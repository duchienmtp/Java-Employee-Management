package BackEnd.AccountManagement;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AccountBUS {

    private ArrayList<Account> accountList = new ArrayList<>();
    private AccountDAO accountDAO = new AccountDAO();

    public AccountBUS() {
        accountList = accountDAO.getAllAccount();
    }

    public ArrayList<Account> getAccountList() {
        return accountList;
    }

    public void readDB() {
        accountList = accountDAO.getAllAccount();
    }

    public String getNextID() {
        String lastID = accountList.get(accountList.size() - 1).getEmployee().getId();
        String characterPart = lastID.substring(0, 2);
        int numberPart = Integer.parseInt(lastID.substring(2));
        numberPart++;
        String nextID = characterPart + String.format("%03d", numberPart);
        return nextID;
    }

    public Account getAccountById(String userId) {
        return accountDAO.getAccountById(userId);
    }

    public Boolean addAccount(Account account) {
        Boolean ok = accountDAO.addNewAccount(account);

        if (ok) {
            accountList.add(account);
            JOptionPane.showMessageDialog(null, "Thêm mới thành công !", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        }
        return ok;
    }

    public void updateAccount(Account account) {
        Boolean ok = accountDAO.updateAccount(account);

        if (ok) {
            for (int i = 0; i < accountList.size(); i++) {
                if (accountList.get(i).getEmployee().getId().equals(account.getEmployee().getId())) {
                    accountList.set(i, account);
                    break;
                }
            }
            JOptionPane.showMessageDialog(null, "Cập nhật thành công !", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void deleteAccount(Account account) {
        Boolean ok = accountDAO.deleteAccount(account);

        if (ok) {
            this.readDB();
            JOptionPane.showMessageDialog(null, "Xóa thành công !", "Thông Báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    // public void deleteAccount(Account account) {
    // // Kiểm tra tính hợp lệ của tham số đầu vào
    // if (account == null) {
    // return;
    // }
    //
    // // Xóa tài khoản từ cơ sở dữ liệu
    // Boolean ok = accountDAO.deleteAccount(account);
    //
    // // Kiểm tra kết quả từ phương thức deleteAccount
    // if (ok != null && ok) {
    // // Sử dụng Iterator để duyệt qua danh sách và xóa tài khoản
    // Iterator<Account> iterator = accountList.iterator();
    // while (iterator.hasNext()) {
    // Account currentAccount = iterator.next();
    // if (currentAccount.getUserId().equals(account.getUserId())) {
    // iterator.remove(); // Loại bỏ tài khoản một cách an toàn
    // break;
    // }
    // }
    // }
    // }

    public Boolean getAccountByEmail(String email) {
        return accountDAO.getAccountByEmail(email) != null;
    }
}
