package jp.co.house.service;

public class NewCheckDataService {

	public static NewCheckResult checkStation(String b) {

		if ( b.length() > 10 ) {
			return NewCheckResult.FAILURE;
		}else {
			return NewCheckResult.SUCCESS;
		}


	}

}
