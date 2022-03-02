package moviebuddy.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


/**
 * 부모 클래스에 기본적인 알고리즘의 흐름을 구현하고 중간에 필요한 처리를
 * 자식 클래스에서 위임하는 구조를 디자인 패턴에서는 템플릿 메서드 패턴
 * (template method pattern)이라 한다.
 */
public abstract class MovieFinder {

	/**
	 * 저장된 영화 목록에서 감독으로 영화를 검색한다.
	 *
	 * @param directedBy 감독
	 * @return 검색된 영화 목록
	 */
	public List<Movie> directedBy(String directedBy) {
		return loadMovies().stream()
			.filter(it -> it.getDirector().toLowerCase().contains(directedBy.toLowerCase()))
			.collect(Collectors.toList());
	}

	/**
	 * 저장된 영화 목록에서 개봉년도로 영화를 검색한다.
	 *
	 * @param releasedYearBy
	 * @return 검색된 영화 목록
	 */
	public List<Movie> releasedYearBy(int releasedYearBy) {
		return loadMovies().stream()
			.filter(it -> Objects.equals(it.getReleaseYear(), releasedYearBy))
			.collect(Collectors.toList());
	}

	/**
	 * 영화 메타데이터를 읽어 저장된 영화 목록을 불러온다.
	 *
	 * @return 불러온 영화 목록
	 */
	public abstract List<Movie> loadMovies();

}
