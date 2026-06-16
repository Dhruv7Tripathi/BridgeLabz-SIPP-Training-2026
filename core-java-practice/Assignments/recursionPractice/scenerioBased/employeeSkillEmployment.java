import java.util.ArrayList;
import java.util.List;

public class employeeSkillEmployment {

  public static List<List<Integer>> findProjectTeams(int[] skills, int target) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(skills, target, 0, new ArrayList<>(), result);
    return result;
  }

  private static void backtrack(int[] skills, int target, int index,
      List<Integer> current, List<List<Integer>> result) {
    if (target == 0) {
      result.add(new ArrayList<>(current));
      return;
    }
    if (index >= skills.length || target < 0) {
      return;
    }

    current.add(skills[index]);
    backtrack(skills, target - skills[index], index + 1, current, result);
    current.remove(current.size() - 1);

    backtrack(skills, target, index + 1, current, result);
  }

  public static void main(String[] args) {
    int[] skills = { 2, 3, 5, 7 };
    int target = 10;

    List<List<Integer>> teams = findProjectTeams(skills, target);
    for (List<Integer> team : teams) {
      System.out.println(team);
    }
  }
}
