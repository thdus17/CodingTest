import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 총 재생 횟수 저장
        Map<String, Integer> totalPlaysByGenre = new HashMap<>();
        // 장르별 곡 정보를 저장할 리스트
        Map<String, List<Song>> songsByGenre = new HashMap<>();

        // 각 곡의 장르와 재생 횟수 정보를 저장
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int playCount = plays[i];

            // 장르별 재생 횟수 합산
            totalPlaysByGenre.put(genre, totalPlaysByGenre.getOrDefault(genre, 0) + playCount);

            // 장르별 곡 정보 저장
            songsByGenre.computeIfAbsent(genre, k -> new ArrayList<>()).add(new Song(i, playCount));
        }

        // 장르를 총 재생 횟수 기준으로 정렬
        List<Map.Entry<String, Integer>> sortedGenres = new ArrayList<>(totalPlaysByGenre.entrySet());
        sortedGenres.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        List<Integer> answer = new ArrayList<>();

        // 각 장르별로 가장 많이 재생된 곡 선택
        for (Map.Entry<String, Integer> genreEntry : sortedGenres) {
            String genre = genreEntry.getKey();
            List<Song> songs = songsByGenre.get(genre);

            // 곡 리스트를 재생 횟수 기준으로 정렬 (동일 재생 횟수일 경우 고유 번호 기준)
            songs.sort((a, b) -> {
                if (b.playCount == a.playCount) {
                    return Integer.compare(a.index, b.index);
                }
                return Integer.compare(b.playCount, a.playCount);
            });

            // 최대 2곡 선택
            for (int j = 0; j < Math.min(2, songs.size()); j++) {
                answer.add(songs.get(j).index);
            }
        }

        // 리스트를 배열로 변환하여 반환
        return answer.stream().mapToInt(i -> i).toArray();

    }
    // 곡 정보를 저장하기 위한 Song 클래스
    static class Song {
        int index;      // 고유 번호
        int playCount;  // 재생 횟수

        Song(int index, int playCount) {
            this.index = index;
            this.playCount = playCount;
        }
    }
}