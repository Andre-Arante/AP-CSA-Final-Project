import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

public class Bot {

    public static void main (String args[]) throws Exception {
        JDABuilder jda = JDABuilder.createDefault("OTc2NTcxNDk3MDIxODQ5NjEw.Gj19B_.6Uu9oqFGTJLjwx4YcKnPFo08gBDN_WbHfL6fzI");

        jda.setActivity(Activity.watching("1test"));
        jda.setStatus(OnlineStatus.ONLINE);
        jda.addEventListeners(new Commands());
        jda.setChunkingFilter(ChunkingFilter.ALL);
        jda.setMemberCachePolicy(MemberCachePolicy.ALL);
        jda.enableIntents(GatewayIntent.GUILD_MEMBERS);

        jda.build();
    }
}
