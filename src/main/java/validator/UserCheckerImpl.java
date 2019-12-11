package validator;

import dao.ValidatorDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserCheckerImpl implements UserChecker {

    private ValidatorDAO validatorDAO;

    @Autowired
    public void setValidatorDAO(ValidatorDAO validatorDAO) {
        this.validatorDAO = validatorDAO;
    }

    @Override
    @Transactional
    public boolean checkLogin(String login) {
        return validatorDAO.checkLogin(login);
    }
}
