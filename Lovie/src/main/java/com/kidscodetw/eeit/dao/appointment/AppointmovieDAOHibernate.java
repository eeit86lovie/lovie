package com.kidscodetw.eeit.dao.appointment;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.Transient;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kidscodetw.eeit.entity.appointment.AppointmentaeditBean;
import com.kidscodetw.eeit.entity.appointment.AppointmentareditBean;
import com.kidscodetw.eeit.entity.appointment.AppointmovieBean;
import com.kidscodetw.eeit.entity.movie.GenreBean;
import com.kidscodetw.eeit.entity.movie.MovieBean;
import com.kidscodetw.eeit.entity.movie.ShowtimeBean;

public class AppointmovieDAOHibernate implements AppointmovieDAO {

	private static final String SELECT_ALL_GENRE = "from GenreBean";
	private static final String SELECT_NAMES_MOVIE = "SELECT name FROM MovieBean";
	private static final String SELECT_NAMES_THEATER = "SELECT name from TheaterBean";
	private static final String SELECT_MOVIE_BY_NAME = "from MovieBean where name=:name";
	private static final String SELECT_Genre_ByMovieId = "SELECT name FROM eeit86.MovieGenre M join eeit86.Genre G on M.genreId = G.id where movieId = ";

	private SessionFactory sessionFactory;
	
	public AppointmovieDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<GenreBean> select_genre_list() {
		Query query = this.getSession().createQuery(SELECT_ALL_GENRE);
		return query.list();
	}
	
	@Override
	public List<String> select_movienames_list() {
		Query query = this.getSession().createQuery(SELECT_NAMES_MOVIE);
		return query.list();
	}

	@Override
	public List<String> select_theaternames_list() {
		Query query = this.getSession().createQuery(SELECT_NAMES_THEATER);
		return query.list();
	}

	@Override
	public ShowtimeBean select_showtime(Integer id) {
		return (ShowtimeBean) this.getSession().get(ShowtimeBean.class, id);
	}
	
	@Override
	public List<AppointmovieBean> select_movieshowtime_list(
			String[] citysels,
			String theatersels,
			String[] genresels,
			String moviesels,
			String showtimeDatebeg,
			String showtimeDateend
			) {
		List<AppointmovieBean> result = null;
		try { 
			/*
			System.out.println("citysels="+citysels.toString()+","+(citysels==null)+","+citysels.length);
			System.out.println("theatersels="+theatersels+","+(theatersels==null)+","+theatersels.length());
			System.out.println("genresels="+genresels.toString()+","+(genresels==null)+","+genresels.length);
			System.out.println("moviesels="+moviesels+","+(moviesels==null)+","+moviesels.length());
			System.out.println("showtimeDatebeg="+showtimeDatebeg+","+(showtimeDatebeg==null)+","+showtimeDatebeg.length());
			System.out.println("showtimeDateend="+showtimeDateend+","+(showtimeDateend==null)+","+showtimeDateend.length());
            citysels=[Ljava.lang.String;@ea0e4b,false,0
			theatersels=,false,0
			genresels=[Ljava.lang.String;@ea0e4b,false,0
			moviesels=,false,0
			showtimeDatebeg=,false,0
			showtimeDateend=,false,0
            */
			StringBuffer wherestr = new StringBuffer();
			if (moviesels != null && moviesels.length()>0) 
			{
				if (wherestr.length() > 0)
					wherestr.append(" and ");
				wherestr.append(" (movieName = '"+moviesels+"') ");
			}
			if (theatersels != null && theatersels.length()>0) 
			{
				if (wherestr.length() > 0)
					wherestr.append(" and ");
				wherestr.append(" (theaterName = '"+theatersels+"') ");
			}
			if ((showtimeDatebeg != null && showtimeDatebeg.length() >0 ) &&
				(showtimeDateend != null && showtimeDateend.length() >0 ))	
			{
				if (wherestr.length() > 0)
					wherestr.append(" and ");
				wherestr.append(" (showtimeDate between '"+showtimeDatebeg+"' and  '"+showtimeDateend+"') ");				
			}
			if ((showtimeDatebeg != null && showtimeDatebeg.length() >0 ) &&
				(showtimeDateend == null || showtimeDateend.length() <=0 ))	
			{
				if (wherestr.length() > 0)
					wherestr.append(" and ");
				wherestr.append(" (showtimeDate >= '"+showtimeDatebeg+"' ) ");				
			}	
			if ((showtimeDatebeg == null || showtimeDatebeg.length() <=0 ) &&
				(showtimeDateend != null && showtimeDateend.length() >0 ))	
			{
				if (wherestr.length() > 0)
					wherestr.append(" and ");
				wherestr.append(" (showtimeDate <= '"+showtimeDateend+"' ) ");				
			}
			if (genresels != null && genresels.length > 0 ) 
			{
				StringBuffer wheregenre = new StringBuffer(genresels[0]);
			}
			//genresels=[Ljava.lang.String;@ea0e4b,false,0
			//citysels=[Ljava.lang.String;@ea0e4b,false,0
			String SELECT_MovieShowtime_BySel =
					"SELECT * FROM eeit86.Showtime S " +
					"where movieName = '名偵探柯南：純黑的惡夢'  " + // moviesels  
					"  and theaterName = '基隆秀泰影城'  " +   // theatersels
					"  and showtimeDate between '2016-08-02' and  '2016-08-02'  " + // showtimeDatebeg+"~"+showtimeDateend
					"  and movieName in (  " +                  // genresels
					"	SELECT M.name  " +
					"	FROM eeit86.Movie M join " +
					"	 (SELECT * FROM eeit86.MovieGenre " +
					"	   where genreid in(1,2,10)) MG " +
					"	on M.id = MG.movieid " +
					"  ) " +
					"  and theaterName in ( " +                 // citysels
					"	SELECT name FROM eeit86.Theater T " +
					"	where city in ('台北市','基隆市') " +
					"  ) " +
					"order by movieName,theaterName,showtimeDate,showtimeTime " ;
							
			SQLQuery query = getSession().createSQLQuery(SELECT_MovieShowtime_BySel);
			query.addEntity(ShowtimeBean.class);
			List<ShowtimeBean> showtimelist = query.list();
			if (showtimelist != null && showtimelist.size() > 0)
			{
				result = new LinkedList<AppointmovieBean>();
				String movieName = showtimelist.get(0).getMovieName();
				Set<ShowtimeBean> showtimeBeans = new LinkedHashSet<ShowtimeBean>();
				for(int j=0;j<showtimelist.size();j++){
					ShowtimeBean sbean = showtimelist.get(j);
					if (! movieName.equals(sbean.getMovieName())) {
						AppointmovieBean appointmovieBean = new AppointmovieBean();
						Query querymovie = this.getSession().createQuery(SELECT_MOVIE_BY_NAME);
						querymovie.setParameter("name", movieName);
						List<MovieBean> movieBeans = querymovie.list();
						appointmovieBean.setName(movieName);
						if (movieBeans.size() != 0) {
							appointmovieBean.setId(movieBeans.get(0).getId());
							appointmovieBean.setRank(movieBeans.get(0).getRank());
							appointmovieBean.setStartTime(movieBeans.get(0).getStartTime());
							appointmovieBean.setIntro(movieBeans.get(0).getIntro());
							appointmovieBean.setShowtimeBeans(showtimeBeans);
							SQLQuery querygenre = this.getSession().createSQLQuery(
							       SELECT_Genre_ByMovieId +  movieBeans.get(0).getId());
							List<String> genrelist = querygenre.list();
							if (movieBeans.size() == 0) {
								appointmovieBean.setGenrelist("");
							}else{
								appointmovieBean.setGenrelist(genrelist.toString());
							}
						}
						result.add(appointmovieBean);
						movieName = sbean.getMovieName();
						showtimeBeans = new LinkedHashSet<ShowtimeBean>();
					}
					showtimeBeans.add(sbean);
				}
				AppointmovieBean appointmovieBean = new AppointmovieBean();
				Query querymovie = this.getSession().createQuery(SELECT_MOVIE_BY_NAME);
				querymovie.setParameter("name", movieName);
				List<MovieBean> movieBeans = querymovie.list();
				appointmovieBean.setName(movieName);
				if (movieBeans.size() != 0) {
					appointmovieBean.setId(movieBeans.get(0).getId());
					appointmovieBean.setRank(movieBeans.get(0).getRank());
					appointmovieBean.setStartTime(movieBeans.get(0).getStartTime());
					appointmovieBean.setIntro(movieBeans.get(0).getIntro());
					appointmovieBean.setShowtimeBeans(showtimeBeans);
					SQLQuery querygenre = this.getSession().createSQLQuery(
						       SELECT_Genre_ByMovieId +  movieBeans.get(0).getId());
					List<String> genrelist = querygenre.list();
					if (movieBeans.size() == 0) {
						appointmovieBean.setGenrelist("");
					}else{
						appointmovieBean.setGenrelist(genrelist.toString());
					}
				}
				result.add(appointmovieBean);				
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}
	
}
