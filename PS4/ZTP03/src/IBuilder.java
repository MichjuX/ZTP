public interface IBuilder {
    IBuilder moveTo(int x, int y);
    IBuilder lineTo(int x, int y);
    IBuilder close();
}
