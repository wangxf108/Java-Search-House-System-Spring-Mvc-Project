package jp.co.house.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.house.db.DAO;
import jp.co.house.entity.NewHouseEntity;
import jp.co.house.model.NewHouseDataModel;
import jp.co.house.model.NewOneOption;
import jp.co.house.service.NewCheckDataService;
import jp.co.house.service.NewCheckResult;

@Controller
public class NewHouseController {


	@RequestMapping(value="/doFind", method=RequestMethod.POST)

	public String findData(@ModelAttribute("DATA1") NewHouseDataModel a, Model xiage) {
		//将a 传给tmp
		String tmp = a.getStation();
		//将tmp 传给 jieguo
		NewCheckResult jieguo = NewCheckDataService.checkStation(tmp);

		ArrayList<NewHouseEntity> allData = DAO.getHouseData(a);

		if(jieguo == NewCheckResult.SUCCESS) {
			xiage.addAttribute("DBJieGuo", allData);
			return "newfindresult";
		}else {
			return "error";
		}
	}

	@RequestMapping(value="/house1", method=RequestMethod.GET)
	public String initPage1(Model next) {
		NewHouseDataModel mm = new NewHouseDataModel(); //prepare data for next image.
		mm.setPricefrom("A1");
		mm.setPriceto("T1");
		mm.setStation("");
		mm.setDistance("noset"); //noset: 初期值，不设定
		mm.setType1("no");
		mm.setType2("no");
		mm.setType3("no");
		mm.setType4("no");
		next.addAttribute("DATA1", mm); //将数据传给findhouse页面

		NewOneOption opt1 = new NewOneOption(); //做下拉框，左侧价格选项
		opt1.setOptText("下限なし");
		opt1.setOptValue("A1");

		NewOneOption opt2 = new NewOneOption();
		opt2.setOptText("3万円以上");
		opt2.setOptValue("A2");

		NewOneOption opt3 = new NewOneOption();
		opt3.setOptText("5万円以上");
		opt3.setOptValue("A3");

		NewOneOption opt4 = new NewOneOption();
		opt4.setOptText("8万円以上");
		opt4.setOptValue("A4");

		ArrayList<NewOneOption> allFrom = new ArrayList<NewOneOption>();
		allFrom.add(opt1);
		allFrom.add(opt2);
		allFrom.add(opt3);
		allFrom.add(opt4);
		next.addAttribute("FROMDATA", allFrom);//


		//The right options of housing price
		NewOneOption to1 = new NewOneOption();
		to1.setOptText("上限なし");
		to1.setOptValue("T1");

		NewOneOption to2 = new NewOneOption();
		to2.setOptText("5万円以下");
		to2.setOptValue("T2");

		NewOneOption to3 = new NewOneOption();
		to3.setOptText("10万円以下");
		to3.setOptValue("T3");

		NewOneOption to4 = new NewOneOption();
		to4.setOptText("15万円以下");
		to4.setOptValue("T4");

		//将上面的选项串成一串ArrayList
		ArrayList<NewOneOption> allTo = new ArrayList<NewOneOption>();

		//pass data to another image
		allTo.add(to1);
		allTo.add(to2);
		allTo.add(to3);
		allTo.add(to4);
		next.addAttribute("TODATA", allTo);

		return "newfindhouse";  //?

	}
}
