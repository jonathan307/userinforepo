package com.files.service;


import com.files.model.RequestDates;
import com.files.model.UserInfo;
import com.files.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String addUser(UserInfo Userinfo){
        String response = "";
        userRepository.save(Userinfo);
        response = "user added";
        return response;
    }

    public List<UserInfo> getspecificUser(int userid) {

        List<UserInfo> resList;

        List<UserInfo> dbList = userRepository.getDataForUserId(userid);

        resList = getUserInfo(dbList);

        return resList;

    }

    public List<UserInfo> getspecificProfession(String profession) {

        List<UserInfo> resList;

        List<UserInfo> dbList = userRepository.getDataForProfession(profession);

        resList = getUserInfo(dbList);

        return resList;
    }

    public List<UserInfo> getspecificDates(RequestDates rdates) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDate datestart = LocalDate.parse(rdates.getStartdate(), formatter);
        LocalDate dateend = LocalDate.parse(rdates.getEnddate(), formatter);
        LocalDate dbdate;
        List<UserInfo> newList = new ArrayList<>();
        UserInfo newListInfo;

        List<UserInfo> dbList = userRepository.getAllRows();

        for (UserInfo ui: dbList) {
            newListInfo = new UserInfo();
            dbdate = LocalDate.parse(ui.getDatecreated().trim(), formatter);
            if (((dbdate.compareTo(datestart) == 0 ) &&
                    (dbdate.compareTo(dateend) == 0 )) ||
                    ((dbdate.compareTo(datestart) > 0 ) &&
                            (dbdate.compareTo(dateend) < 0 ))) {
                newListInfo.setUserId(ui.getUserId());
                newListInfo.setCity(ui.getCity());
                newListInfo.setCountry(ui.getCountry());
                newListInfo.setEmail(ui.getEmail());
                newListInfo.setDatecreated(ui.getDatecreated());
                newListInfo.setFirstName(ui.getFirstName());
                newListInfo.setLastName(ui.getLastName());
                newListInfo.setProfession(ui.getProfession());
                newList.add(newListInfo);
            }
        }

        return newList;
    }

    private List<UserInfo> getUserInfo(List<UserInfo> dbList){

        List<UserInfo> returnList = new ArrayList<>();

        UserInfo Userinfo;

        for(UserInfo ui: dbList){
            Userinfo = new UserInfo();
            Userinfo.setUserId(ui.getUserId());
            Userinfo.setCity(ui.getCity());
            Userinfo.setCountry(ui.getCountry());
            Userinfo.setEmail(ui.getEmail());
            Userinfo.setDatecreated(ui.getDatecreated());
            Userinfo.setFirstName(ui.getFirstName());
            Userinfo.setLastName(ui.getLastName());
            Userinfo.setProfession(ui.getProfession());
            returnList.add(Userinfo);
        }
        return returnList;
    }

}
