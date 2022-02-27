
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;

import com.sun.java.swing.plaf.windows.WindowsComboBoxUI;

import net.skidcode.gh.Direction;
import net.skidcode.gh.TimeStatus;
import net.skidcode.gh.Teleport;
import net.skidcode.gh.item.Item;
import net.skidcode.gh.item.ItemSet;

/* renamed from: GUI  reason: default package */
@SuppressWarnings("serial")
public class GuiOptions extends JFrame {
	public static JFrame frame;
    private gj gjInstance; /*MC BASECLASS*/
    private ItemDeleter itemDeleterInstance = null;
    private ItemSpawner itemSpawnerInstance = null;
    private static GuiOptions instance;
    /* renamed from: I  reason: collision with root package name */
    public JLabel playerAmount;
    private MCThread minecraftThread = null;
    private ArrayList<Item> ITEMS = new ArrayList<Item>();
    private ArrayList<Item> RELATED = new ArrayList<Item>();
    private ArrayList<ItemSet> TOOLS = new ArrayList<ItemSet>();
    private ArrayList<ItemSet> ARMOR = new ArrayList<ItemSet>();
    private ArrayList<Teleport> WAYPOINTS = new ArrayList<Teleport>();
    private DefaultListModel<String> WAYPOINTNAMES;
    private DefaultListModel<String> components;
    String[] addContainerGap = null;
    private JComboBox<WindowsComboBoxUI> addElement;
    private ButtonGroup addGap;
    private ButtonGroup addGroup;
    private JRadioButton addKeyListener;
    private JButton addMouseListener;
    private JRadioButton addPreferredGap;
    private JCheckBox fireImmunity;
    private JCheckBox append;
    private JButton hideButton;
    private JCheckBox at;
    private JCheckBox au;
    private JCheckBox av;
    private JSpinner aw;
    private JList ax;
    private JTextField c;
    private JButton charAt;
    private JLabel clear;
    private JLabel compile;
    private JLabel createParallelGroup;
    private JLabel clientNameLabel;
    private JLabel authorLabel;
    private JLabel updateWebsite;
    private JLabel exit;
    private JLabel usersCounterLabel;
    private JLabel textTeleportName;
    private JLabel get;
    private JPanel getAccessibleContext;
    private JRadioButton getSelectedIndex;
    private JScrollPane getText;
    private JScrollPane getValue;
    private JTabbedPane isSelected;
    private JRadioButton iterator;
    private JRadioButton length;
    private JRadioButton matcher;
    private JRadioButton next;
    private JPanel parseInt;
    private JCheckBox printStackTrace;
    private JButton buttonSaveTeleport;
    private JRadioButton setEnabled;
    private JButton setFont;
    private JButton setHorizontalGroup;
    private JPanel setLayout;
    private JButton setModel;
    private JList setSelected;
    private JTextField setSelectionMode;
    private JComboBox setText;
    private JCheckBox setVerifyInputWhenFocusTarget;
    private JRadioButton setVerticalGroup;

    public GuiOptions(gj var1) {
        registerItems();
        instance = this;
        this.addContainerGap = new String[this.ITEMS.size()];
        this.WAYPOINTNAMES = new DefaultListModel<String>();
        this.components = new DefaultListModel<String>();
        if (this.gjInstance == null) {
            if (var1 == null) {
                JOptionPane.showMessageDialog((Component) null, "An error has occured. An update is needed or Minecraft servers are down.", "MCCheat", 2);
                System.exit(0);
            }
            this.gjInstance = var1;
        }
        if (this.itemDeleterInstance == null) {
            this.itemDeleterInstance = new ItemDeleter(this.gjInstance);
        }
        if (this.itemSpawnerInstance == null) {
            this.itemSpawnerInstance = new ItemSpawner(this.gjInstance);
        }
        if (this.minecraftThread == null) {
            this.minecraftThread = new MCThread(this.gjInstance);
            this.minecraftThread.startthread();
        }
        Iterator var3 = this.ITEMS.iterator();
        while (var3.hasNext()) {
            Item var4 = (Item) var3.next();
            this.RELATED.add(var4);
        }
        addObjects();
    }

    private boolean BASELINE() {
        return (this.gjInstance.e == null || this.gjInstance.g == null || this.gjInstance.g.e == null) ? false : true;
    }

    private void registerItems() {
        this.ITEMS.add(new Item("Stone", 1, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Grass", 2, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Dirt", 3, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Cobblestone", 4, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Wood", 5, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Sapling", 6, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Bedrock (Adminium)", 7, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Water", 8, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Still Water", 9, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Lava", 10, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Still Lava", 11, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Sand", 12, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Gravel", 13, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Gold Ore", 14, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Iron Ore", 15, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Coal Ore", 16, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Tree", 17, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Leaves", 18, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Sponge", 19, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Glass", 20, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Cloth", 35, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Yellow Flower", 37, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Red Flower", 38, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Brown Mushroom", 39, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Red Mushroom", 40, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Gold Block", 41, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Iron Block", 42, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Double Stair", 43, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Single Stair", 44, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Brick", 45, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("TNT", 46, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Bookshelf", 47, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Mossy Cobblestone", 48, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Obsidian", 49, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Torch", 50, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Fire", 51, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Mob Spawner", 52, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Wood Stairs", 53, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Chest", 54, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Redstone Dust", 55, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Diamond Ore", 56, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Diamond Block", 57, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Workbench", 58, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Crop", 59, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Soil", 60, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Furnace", 61, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Lit Furnace", 62, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Sign Block", 63, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Wood Door Block", 64, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Ladder", 65, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Rails", 66, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Cobblestone Stairs", 67, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Sign Block Top", 68, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Lever", 69, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Rock Plate", 70, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Iron Door Block", 71, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Wood Plate", 72, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Red Stone Ore (1)", 73, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Red Stone Ore (2)", 74, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Red Stone Torch (Off)", 75, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Red Stone Torch (On)", 76, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Button", 77, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Snow", 78, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Ice", 79, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Snow Block", 80, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Cactus", 81, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Clay Block", 82, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Reed Block", 83, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Juke Box", 84, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Wooden Fence", 85, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Pumpkin Helmet", 86, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Hell Stone", 87, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Hell Dirt", 88, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Hell Light", 89, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Portal", 90, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Pumpkin", 91, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Iron Shovel", 256, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Iron Pickaxe", 257, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Iron Axe", 258, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Flint And Steel", 259, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Apple", 260, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Bow", 261, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Arrow", 262, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Coal", 263, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Diamond", 264, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Iron Bar", 265, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Gold Bar", 266, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Iron Sword", 267, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Wood Sword", 268, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Wood Shovel", 269, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Wood Pickaxe", 270, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Wood Axe", 271, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Stone Sword", 272, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Stone Shovel", 273, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Stone Pickaxe", 274, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Stone Axe", 275, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Diamond Sword", 276, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Diamond Shovel", 277, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Diamond Pickaxe", 278, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Diamond Axe", 279, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Stick", 280, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Bowl", 281, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Bowl With Soup", 282, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Gold Sword", 283, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Gold Shovel", 284, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Gold Pickaxe", 285, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Gold Axe", 286, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("String", 287, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Feather", 288, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Gunpowder", 289, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Wood Hoe", 290, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Stone Hoe", 291, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Iron Hoe", 292, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Diamond Hoe", 293, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Gold Hoe", 294, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Seeds", 295, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Wheat", 296, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Bread", 297, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Leather Helmet", 298, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Leather Chestplate", 299, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Leather Pants", 300, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Leather Boots", 301, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Chainmail Helmet", 302, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Chainmail Chestplate", 303, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Chainmail Pants", 304, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Chainmail Boots", 305, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Iron Helmet", 306, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Iron Chestplate", 307, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Iron Pants", 308, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Iron Boots", 309, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Diamond Helmet", 310, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Diamond Chestplate", 311, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Diamond Pants", 312, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Diamond Boots", 313, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Gold Helmet", 314, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Gold Chestplate", 315, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Gold Pants", 316, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Gold Boots", 317, net.skidcode.gh.Type.EQUIPMENT));
        this.ITEMS.add(new Item("Flint", 318, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Meat", 319, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Cooked Meat", 320, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Painting", 321, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Golden Apple", 322, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Sign", 323, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Wood Door", 324, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Bucket", 325, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Water Bucket", 326, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Lava Bucket", 327, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Minecart", 328, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Saddle", 329, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Iron Door", 330, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Red Stone Dust", 331, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Snowball", 332, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Boat", 333, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Leather", 334, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Milk Bucket", 335, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Brick", 336, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Clay", 337, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Reed", 338, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Paper", 339, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Book", 340, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Slime Orb", 341, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Storage Minecart", 342, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Powered Minecart", 343, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Egg", 344, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Compass", 345, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Fishing Rod", 346, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Watch", 347, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Gold Dust", 348, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Fish", 349, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Cooked Fish", 350, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Gold Record", 2256, net.skidcode.gh.Type.REGULAR));
        this.ITEMS.add(new Item("Green Record", 2257, net.skidcode.gh.Type.REGULAR));
        this.TOOLS.add(new ItemSet("Wood", new int[]{269, 270, 271, 290}));
        this.TOOLS.add(new ItemSet("Gold", new int[]{284, 285, 286, 294}));
        this.TOOLS.add(new ItemSet("Stone", new int[]{273, 274, 275, 291}));
        this.TOOLS.add(new ItemSet("Iron", new int[]{256, 257, 258, 292}));
        this.TOOLS.add(new ItemSet("Diamond", new int[]{277, 278, 279, 293}));
        this.ARMOR.add(new ItemSet("Leather", new int[]{298, 299, 300, 301}));
        this.ARMOR.add(new ItemSet("Chainmail", new int[]{302, 303, 304, 305}));
        this.ARMOR.add(new ItemSet("Iron", new int[]{306, 307, 308, 309}));
        this.ARMOR.add(new ItemSet("Gold", new int[]{314, 315, 316, 317}));
        this.ARMOR.add(new ItemSet("Diamond", new int[]{310, 311, 312, 313}));
    }

    private void addObjects() {
        this.addGap = new ButtonGroup();
        this.charAt = new JButton();
        this.getSelectedIndex = new JRadioButton();
        this.addGroup = new ButtonGroup();
        this.authorLabel = new JLabel();
        this.updateWebsite = new JLabel();
        this.clientNameLabel = new JLabel();
        this.hideButton = new JButton();
        this.usersCounterLabel = new JLabel();
        this.playerAmount = new JLabel();
        this.isSelected = new JTabbedPane();
        this.parseInt = new JPanel();
        this.fireImmunity = new JCheckBox();
        this.au = new JCheckBox();
        this.printStackTrace = new JCheckBox();
        this.append = new JCheckBox();
        this.addKeyListener = new JRadioButton();
        this.iterator = new JRadioButton();
        this.matcher = new JRadioButton();
        this.at = new JCheckBox();
        this.next = new JRadioButton();
        this.setEnabled = new JRadioButton();
        this.addPreferredGap = new JRadioButton();
        this.setVerticalGroup = new JRadioButton();
        this.length = new JRadioButton();
        this.compile = new JLabel();
        this.get = new JLabel();
        this.setLayout = new JPanel();
        this.av = new JCheckBox();
        this.aw = new JSpinner(new SpinnerNumberModel(1, 1, 64, 1));
        this.setVerifyInputWhenFocusTarget = new JCheckBox();
        this.setText = new JComboBox();
        this.createParallelGroup = new JLabel();
        this.setHorizontalGroup = new JButton();
        this.exit = new JLabel();
        this.addElement = new JComboBox<WindowsComboBoxUI>();
        this.setFont = new JButton();
        this.addMouseListener = new JButton();
        this.c = new JTextField();
        this.getValue = new JScrollPane();
        this.ax = new JList();
        this.clear = new JLabel();
        this.getAccessibleContext = new JPanel();
        this.textTeleportName = new JLabel();
        this.setSelectionMode = new JTextField();
        this.buttonSaveTeleport = new JButton();
        this.setModel = new JButton();
        this.getText = new JScrollPane();
        this.setSelected = new JList();
        this.charAt.setText("jButton1");
        this.getSelectedIndex.setText("jRadioButton1");
        setTitle("MCCheat");
        setAlwaysOnTop(true);
        setResizable(false);
        this.authorLabel.setText("Original author was youtube.com/MinecraftCheat");
        this.updateWebsite.setText("Old site about updates www.mccheat.net");
        this.clientNameLabel.setFont(new Font("Tahoma", 1, 11));
        this.clientNameLabel.setText("MCCheat Forever");
        this.hideButton.setText("Hide");
        this.hideButton.addActionListener(new ActionListener() {

            public final void actionPerformed(ActionEvent var1) {
                GuiOptions.hideCurrentScreen(GuiOptions.instance, var1);
            }
        });
        this.usersCounterLabel.setText("People Using MCCheat:");
        this.playerAmount.setText("0");
        this.fireImmunity.setText("Fire Proof");
        this.fireImmunity.addActionListener(new ActionListener() {
            public final void actionPerformed(ActionEvent var1) {
                GuiOptions.Z(GuiOptions.instance, var1);
            }
        });
        this.au.setText("Invincibility");
        this.au.addActionListener(new ActionListener() {

            public final void actionPerformed(ActionEvent var1) {
                GuiOptions.C(GuiOptions.instance, var1);
            }
        });
        this.printStackTrace.setText("Oxygen");
        this.printStackTrace.addActionListener(new ActionListener() {

            public final void actionPerformed(ActionEvent var1) {
                GuiOptions.B(GuiOptions.instance, var1);
            }
        });
        this.append.setText("Fly Mode");
        this.append.addActionListener(new ActionListener() {
            /* class defpackage.GUI.AnonymousClass5 */
            public final void actionPerformed(ActionEvent var1) {
                GuiOptions.D(GuiOptions.instance, var1);
            }
        });
        this.addGap.add(this.addKeyListener);
        this.addKeyListener.setText("Day");
        this.addKeyListener.addActionListener(new ActionListener() {

            public final void actionPerformed(ActionEvent var1) {
                GuiOptions.F(GuiOptions.instance, var1);
            }
        });
        this.addGap.add(this.iterator);
        this.iterator.setText("Night");
        this.iterator.addActionListener(new ActionListener() {

            public final void actionPerformed(ActionEvent var1) {
                GuiOptions.J(GuiOptions.instance, var1);
            }
        });
        this.addGap.add(this.matcher);
        this.matcher.setSelected(true);
        this.matcher.setText("Normal");
        this.matcher.addActionListener(new ActionListener() {

            public final void actionPerformed(ActionEvent var1) {
                GuiOptions.S(GuiOptions.instance, var1);
            }
        });
        this.at.setText("Hover Mode");
        this.at.addActionListener(new ActionListener() {
            public final void actionPerformed(ActionEvent var1) {
                GuiOptions.A(GuiOptions.instance, var1);
            }
        });
        this.addGroup.add(this.next);
        this.next.setText("On");
        this.next.addActionListener(new ActionListener() {

            public final void actionPerformed(ActionEvent var1) {
                GuiOptions.setDirectionNorth(GuiOptions.instance, var1);
            }
        });
        this.addGroup.add(this.setEnabled);
        this.setEnabled.setText("South");
        this.setEnabled.addActionListener(new ActionListener() {

            public final void actionPerformed(ActionEvent var1) {
                GuiOptions.setDirectionSouth(GuiOptions.instance, var1);
            }
        });
        this.addGroup.add(this.addPreferredGap);
        this.addPreferredGap.setText("East");
        this.addPreferredGap.addActionListener(new ActionListener() {

            public final void actionPerformed(ActionEvent var1) {
                GuiOptions.setDirectionEast(GuiOptions.instance, var1);
            }
        });
        this.addGroup.add(this.setVerticalGroup);
        this.setVerticalGroup.setText("West");
        this.setVerticalGroup.addActionListener(new ActionListener() {

            public final void actionPerformed(ActionEvent var1) {
                GuiOptions.setDirectionWest(GuiOptions.instance, var1);
            }
        });
        this.addGroup.add(this.length);
        this.length.setSelected(true);
        this.length.setText("Off");
        this.length.addActionListener(new ActionListener() {

            public final void actionPerformed(ActionEvent var1) {
                GuiOptions.setDirectionNone(GuiOptions.instance, var1);
            }
        });
        this.get.setText("Movement Direction");
        GroupLayout var2 = new GroupLayout(this.parseInt);
        this.parseInt.setLayout(var2);
        var2.setHorizontalGroup(var2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(var2.createSequentialGroup().addContainerGap().addGroup(var2.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.get, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, var2.createSequentialGroup().addGroup(var2.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.length).addComponent(this.next)).addGap(35, 35, 35).addComponent(this.compile)).addGroup(GroupLayout.Alignment.LEADING, var2.createSequentialGroup().addGroup(var2.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.append, GroupLayout.Alignment.LEADING).addComponent(this.fireImmunity, GroupLayout.Alignment.LEADING).addComponent(this.printStackTrace, GroupLayout.Alignment.LEADING).addComponent(this.au, GroupLayout.Alignment.LEADING).addComponent(this.at, GroupLayout.Alignment.LEADING, -1, -1, 32767)).addGap(18, 18, 18).addGroup(var2.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.iterator, -1, -1, 32767).addComponent(this.matcher, -1, -1, 32767).addComponent(this.addKeyListener)))).addContainerGap(18, 32767)));
        var2.setVerticalGroup(var2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(var2.createSequentialGroup().addContainerGap().addGroup(var2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(var2.createSequentialGroup().addComponent(this.au).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.printStackTrace).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.fireImmunity).addComponent(this.append).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.at)).addGroup(var2.createSequentialGroup().addComponent(this.matcher).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.addKeyListener).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.iterator))).addGap(18, 18, 18).addComponent(this.get).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(var2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(var2.createSequentialGroup().addGap(95, 95, 95).addComponent(this.compile)).addGroup(var2.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(var2.createSequentialGroup().addGap(23, 23, 23).addComponent(this.next).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)).addGroup(GroupLayout.Alignment.TRAILING, var2.createSequentialGroup().addComponent(this.length).addGap(92, 92, 92)))).addGap(167, 167, 167)));
        this.isSelected.addTab("Options", this.parseInt);
        this.av.setText("Spawn Invincible Items");
        this.aw.setEnabled(true);
        this.aw.setVerifyInputWhenFocusTarget(false);
        this.setVerifyInputWhenFocusTarget.setText("Spawn Unlimited Stacks");
        this.setVerifyInputWhenFocusTarget.addActionListener(new ActionListener() {

            public final void actionPerformed(ActionEvent var1) {
                GuiOptions.M(GuiOptions.instance, var1);
            }
        });
        this.setText.setModel(new DefaultComboBoxModel(new String[]{"Wood", "Gold", "Stone", "Iron", "Diamond"}));
        this.createParallelGroup.setText("Tools");
        this.setHorizontalGroup.setText("Spawn");
        this.setHorizontalGroup.addActionListener(new ActionListener() {

            public final void actionPerformed(ActionEvent var1) {
                GuiOptions.spawnEventHandle(GuiOptions.instance, var1);
            }
        });
        this.exit.setText("Armor Set");
        this.addElement.setModel(new DefaultComboBoxModel(new String[]{"Leather", "Chainmail", "Iron", "Gold", "Diamond"}));
        this.setFont.setText("Spawn");
        this.setFont.addActionListener(new ActionListener() {

            public final void actionPerformed(ActionEvent var1) {
                GuiOptions.spawnArmorEvent(GuiOptions.instance, var1);
            }
        });
        this.addMouseListener.setText("Delete All Items");
        this.addMouseListener.addActionListener(new ActionListener() {
            public final void actionPerformed(ActionEvent var1) {
                GuiOptions.deleteItemsEvent(GuiOptions.instance, var1);
            }
        });
        this.c.addKeyListener(new KeyAdapter() {
            public final void keyReleased(KeyEvent var1) {
                GuiOptions.I(GuiOptions.instance, var1);
            }
        });
        this.ax.setSelectionMode(0);
        this.ax.setModel(this.components);
        this.ax.addMouseListener(new MouseAdapter() {

            public final void mouseClicked(MouseEvent var1) {
                GuiOptions.I(GuiOptions.instance, var1);
            }
        });
        this.getValue.setViewportView(this.ax);
        this.clear.setText("Item:");
        GroupLayout var3 = new GroupLayout(this.setLayout);
        this.setLayout.setLayout(var3);
        var3.setHorizontalGroup(var3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(var3.createSequentialGroup().addGroup(var3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(var3.createSequentialGroup().addGap(8, 8, 8).addGroup(var3.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.setFont, -1, 170, 32767).addComponent(this.addMouseListener, -1, 170, 32767).addComponent(this.setHorizontalGroup, -1, 170, 32767).addGroup(var3.createSequentialGroup().addComponent(this.exit).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.addElement, 0, 112, 32767)).addGroup(var3.createSequentialGroup().addComponent(this.createParallelGroup).addGap(18, 18, 18).addComponent(this.setText, 0, 127, 32767)))).addGroup(var3.createSequentialGroup().addContainerGap().addGroup(var3.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.getValue, -1, 168, 32767).addComponent(this.av).addGroup(var3.createSequentialGroup().addComponent(this.setVerifyInputWhenFocusTarget).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.aw, -2, -1, -2)).addGroup(var3.createSequentialGroup().addComponent(this.clear).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.c, -1, 132, 32767))))).addContainerGap()));
        var3.setVerticalGroup(var3.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(var3.createSequentialGroup().addContainerGap().addComponent(this.av).addGap(2, 2, 2).addGroup(var3.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.setVerifyInputWhenFocusTarget).addComponent(this.aw, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(var3.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.c, -2, -1, -2).addComponent(this.clear)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.getValue, -1, 78, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(var3.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.setText, -2, -1, -2).addComponent(this.createParallelGroup)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.setHorizontalGroup).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(var3.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.exit).addComponent(this.addElement, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.setFont).addGap(4, 4, 4).addComponent(this.addMouseListener).addContainerGap()));
        this.isSelected.addTab("Spawning", this.setLayout);
        this.textTeleportName.setText("Teleport Name:");
        this.buttonSaveTeleport.setText("Save Teleport");
        this.buttonSaveTeleport.addActionListener(new ActionListener() {
            /* class defpackage.GUI.AnonymousClass21 */
            public final void actionPerformed(ActionEvent var1) {
                GuiOptions.saveWaypointEvent(GuiOptions.instance, var1);
            }
        });
        this.setModel.setText("Teleport");
        this.setModel.addActionListener(new ActionListener() {
            /* class defpackage.GUI.AnonymousClass22 */
            public final void actionPerformed(ActionEvent var1) {
                GuiOptions.R(GuiOptions.instance, var1);
            }
        });
        this.setSelected.setSelectionMode(0);
        this.setSelected.setModel(this.WAYPOINTNAMES);
        this.getText.setViewportView(this.setSelected);
        GroupLayout var4 = new GroupLayout(this.getAccessibleContext);
        this.getAccessibleContext.setLayout(var4);
        var4.setHorizontalGroup(var4.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(GroupLayout.Alignment.TRAILING, var4.createSequentialGroup().addContainerGap().addGroup(var4.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.getText, GroupLayout.Alignment.LEADING, -1, 168, 32767).addComponent(this.buttonSaveTeleport, GroupLayout.Alignment.LEADING, -1, 168, 32767).addGroup(GroupLayout.Alignment.LEADING, var4.createSequentialGroup().addComponent(this.textTeleportName).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.setSelectionMode, -1, 84, 32767)).addComponent(this.setModel, GroupLayout.Alignment.LEADING, -1, 168, 32767)).addContainerGap()));
        var4.setVerticalGroup(var4.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(var4.createSequentialGroup().addContainerGap().addGroup(var4.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.textTeleportName).addComponent(this.setSelectionMode, -2, -1, -2)).addGap(18, 18, 18).addComponent(this.buttonSaveTeleport).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.getText, -1, 193, 32767).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.setModel).addContainerGap()));
        this.isSelected.addTab("Teleporting", this.getAccessibleContext);
        GroupLayout var5 = new GroupLayout(getContentPane());
        getContentPane().setLayout(var5);
        var5.setHorizontalGroup(var5.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(var5.createSequentialGroup().addGroup(var5.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(var5.createSequentialGroup().addGap(62, 62, 62).addComponent(this.updateWebsite)).addGroup(var5.createSequentialGroup().addGap(25, 25, 25).addComponent(this.authorLabel)).addGroup(var5.createSequentialGroup().addContainerGap().addComponent(this.hideButton, -1, 193, 32767)).addGroup(var5.createSequentialGroup().addGap(45, 45, 45).addComponent(this.usersCounterLabel).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.playerAmount, -2, 26, -2))).addContainerGap()).addGroup(GroupLayout.Alignment.TRAILING, var5.createSequentialGroup().addContainerGap(49, 32767).addComponent(this.clientNameLabel).addGap(49, 49, 49)).addGroup(var5.createSequentialGroup().addContainerGap().addComponent(this.isSelected, -1, 193, 32767).addContainerGap()));
        var5.setVerticalGroup(var5.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(var5.createSequentialGroup().addContainerGap().addComponent(this.clientNameLabel, -2, 14, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.hideButton).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(var5.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.playerAmount).addComponent(this.usersCounterLabel)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.isSelected, -2, 339, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767).addComponent(this.authorLabel).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.updateWebsite).addContainerGap()));
        this.isSelected.getAccessibleContext().setAccessibleName("Options");
        pack();
        System.out.println(addElement);
    }

    private void hideCurrentScreen(ActionEvent var1) {
        Main.optionsInstance.setVisible(false);
        Main.smallGui.setVisible(true);
    }
    
    private void setMovementDirection(ActionEvent var1, Direction d) {
    	this.minecraftThread.setCurrentMovementDirection(d);
    }
    


    private void add(ActionEvent var1) {
        if (this.at.isSelected()) {
            this.minecraftThread.toggleHoverMode(true);
        } else {
            this.minecraftThread.toggleHoverMode(false);
        }
    }

    private void addActionListener(ActionEvent var1) {
        this.minecraftThread.setTime(TimeStatus.NORMAL);
    }

    private void addComponent(ActionEvent var1) {
        this.minecraftThread.setTime(TimeStatus.NIGHT);
    }

    private void addContainerGap(ActionEvent var1) {
        this.minecraftThread.setTime(TimeStatus.DAY);
    }

    private void addElement(ActionEvent var1) {
        if (this.append.isSelected()) {
            this.minecraftThread.toggleFly(true);
        } else {
            this.minecraftThread.toggleFly(false);
        }
    }

    private void addGap(ActionEvent var1) {
        if (this.printStackTrace.isSelected()) {
            this.minecraftThread.toggleBreathUnderwater(true);
        } else {
            this.minecraftThread.toggleBreathUnderwater(false);
        }
    }

    private void addGroup(ActionEvent var1) {
        if (this.au.isSelected()) {
            this.minecraftThread.toggleGodMode(true);
        } else {
            this.minecraftThread.toggleGodMode(false);
        }
    }

    private void addKeyListener(ActionEvent var1) {
        if (this.fireImmunity.isSelected()) {
            this.minecraftThread.toggleNoFireDamage(true);
        } else {
            this.minecraftThread.toggleNoFireDamage(false);
        }
    }

    private void addMouseListener(ActionEvent var1) {
        if (this.setSelected.getSelectedIndex() >= 0) {
            Teleport var2 = (Teleport) this.WAYPOINTS.get(this.setSelected.getSelectedIndex());
            this.gjInstance.g.c(var2.getX(), var2.getY(), var2.getZ(), this.gjInstance.g.aC, 0.0f);
            bq bqVar = this.gjInstance.g;
            bq bqVar2 = this.gjInstance.g;
            this.gjInstance.g.av = 0.0d;
            bqVar2.au = 0.0d;
            bqVar.at = 0.0d;
        }
    }

    private void addWaypoint(ActionEvent var1) {
        String var2 = this.setSelectionMode.getText().trim();
        if (var2 == null || var2.equals("")) {
            JOptionPane.showMessageDialog((Component) null, "Please enter a name for the teleport.");
            return;
        }
        String waypointName = aw(var2);
        this.WAYPOINTS.add(new Teleport(waypointName, this.gjInstance.g.aw, this.gjInstance.g.ax, this.gjInstance.g.ay));
        this.WAYPOINTNAMES.addElement(waypointName);
    }

    private void addTab(MouseEvent var1) {
        if (!BASELINE()) {
            JOptionPane.showMessageDialog((Component) null, "Please login to an SMP server or load Single Player first.");
            return;
        }
        int var2 = this.ax.getSelectedIndex();
        if (var2 >= 0) {
            short var3 = 0;
            Item var4 = (Item) this.RELATED.get(var2);
            if (var4.getType() == net.skidcode.gh.Type.REGULAR) {
                var3 = -32767;
            }
            int var5 = Integer.parseInt(this.aw.getValue().toString());
            if (var2 > -1) {
                try {
                    ItemSpawner itemSpawner = this.itemSpawnerInstance;
                    int Z = var4.getItemID();
                    if (!this.av.isSelected()) {
                        var3 = 0;
                    }
                    if (this.setVerifyInputWhenFocusTarget.isSelected()) {
                        var5 = -1;
                    }
                    itemSpawner.spawnItemToNextFreeSlot(Z, var3, var5);
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog((Component) null, "Please login to an SMP server or load Single Player first.");
                }
            } else {
                JOptionPane.showMessageDialog((Component) null, "Please select an Item Set to spawn.");
            }
        }
    }

    private void append(KeyEvent var1) {
        String var2 = this.c.getText();
        this.components.clear();
        this.RELATED.clear();
        if (var2 != null && !var2.equals("")) {
            Pattern var3 = Pattern.compile(var2, 2);
            Iterator var5 = this.ITEMS.iterator();
            while (var5.hasNext()) {
                Item var6 = (Item) var5.next();
                if (var3.matcher(var6.getName()).find()) {
                    this.components.addElement(var6.getName());
                    this.RELATED.add(var6);
                }
            }
        }
    }

    private void clearInventory(ActionEvent var1) {
        if (!BASELINE()) {
            JOptionPane.showMessageDialog((Component) null, "Please login to an SMP server or load Single Player first.");
            return;
        }
        try {
            this.itemDeleterInstance.clearInventory();
        } catch (Exception e2) {
            JOptionPane.showMessageDialog((Component) null, "Please login to an SMP server or load Single Player first.");
        }
    }

    private void spawnItemToSpecificSlot(ActionEvent var1) {
        if (!BASELINE()) {
            JOptionPane.showMessageDialog((Component) null, "Please login to an SMP server or load Single Player first.");
            return;
        }
        int var2 = this.addElement.getSelectedIndex();
        int[] var4 = ((ItemSet) this.ARMOR.get(var2)).I();
        if (var2 > -1) {
            for (int var5 = 0; var5 < var4.length; var5++) {
                try {
                    this.itemSpawnerInstance.spawnItemToSpecificSlot(var4[var5], this.av.isSelected() ? -32767 : 0, 1, var5);
                } catch (Exception var6) {
                    JOptionPane.showMessageDialog((Component) null, "Please login to an SMP server or load Single Player first.");
                    var6.printStackTrace();
                    return;
                }
            }
            return;
        }
        JOptionPane.showMessageDialog((Component) null, "Please select an Item Set to spawn.");
    }

    private void spawnItemToNextFreeSlot(ActionEvent var1) {
        if (!BASELINE()) {
            JOptionPane.showMessageDialog((Component) null, "Please login to an SMP server or load Single Player first.");
            return;
        }
        int var2 = this.setText.getSelectedIndex();
        int[] var4 = ((ItemSet) this.TOOLS.get(var2)).I();
        if (var2 > -1) {
            for (int i : var4) {
                try {
                    this.itemSpawnerInstance.spawnItemToNextFreeSlot(i, this.av.isSelected() ? -32767 : 0, 1);
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog((Component) null, "Please login to an SMP server or load Single Player first.");
                    return;
                }
            }
            return;
        }
        JOptionPane.showMessageDialog((Component) null, "Please select an Item Set to spawn.");
    }

    private void av(ActionEvent var1) {
        if (this.setVerifyInputWhenFocusTarget.isSelected()) {
            this.aw.setEnabled(false);
        } else {
            this.aw.setEnabled(true);
        }
    }

    public static final String aw(String var0) {
        return var0.length() > 0 ? Character.toUpperCase(var0.charAt(0)) + var0.substring(1) : var0;
    }

    static final void hideCurrentScreen(GuiOptions var0, ActionEvent var1) {
        var0.hideCurrentScreen(var1);
    }

    static final void Z(GuiOptions var0, ActionEvent var1) {
        var0.addKeyListener(var1);
    }

    public static final boolean Z() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            return true;
        } catch (Exception e2) {
            System.out.println("Okay, I won't have a native L&F.");
            return false;
        }
    }

    static final void C(GuiOptions var0, ActionEvent var1) {
        var0.addGroup(var1);
    }

    static final void B(GuiOptions var0, ActionEvent var1) {
        var0.addGap(var1);
    }

    static final void D(GuiOptions var0, ActionEvent var1) {
        var0.addElement(var1);
    }

    static final void F(GuiOptions var0, ActionEvent var1) {
        var0.addContainerGap(var1);
    }

    static final void J(GuiOptions var0, ActionEvent var1) {
        var0.addComponent(var1);
    }

    static final void S(GuiOptions var0, ActionEvent var1) {
        var0.addActionListener(var1);
    }

    static final void A(GuiOptions var0, ActionEvent var1) {
        var0.add(var1);
    }
    
    static final void setDirectionNorth(GuiOptions var0, ActionEvent var1) {
        var0.setMovementDirection(var1,Direction.NORTH);
    }

    static final void setDirectionSouth(GuiOptions var0, ActionEvent var1) {
        var0.setMovementDirection(var1,Direction.SOUTH);
    }

    static final void setDirectionEast(GuiOptions var0, ActionEvent var1) {
        var0.setMovementDirection(var1,Direction.EAST);
    }

    static final void setDirectionWest(GuiOptions var0, ActionEvent var1) {
        var0.setMovementDirection(var1,Direction.WEST);
    }

    static final void setDirectionNone(GuiOptions var0, ActionEvent var1) {
        var0.setMovementDirection(var1,Direction.NONE);
    }

    static final void M(GuiOptions var0, ActionEvent var1) {
        var0.av(var1);
    }

    static final void spawnEventHandle(GuiOptions var0, ActionEvent var1) {
        var0.spawnItemToNextFreeSlot(var1);
    }

    static final void spawnArmorEvent(GuiOptions var0, ActionEvent var1) {
        var0.spawnItemToSpecificSlot(var1);
    }

    static final void deleteItemsEvent(GuiOptions var0, ActionEvent var1) {
        var0.clearInventory(var1);
    }

    static final void I(GuiOptions var0, KeyEvent var1) {
        var0.append(var1);
    }

    public static final File I() {
        String str1 = System.getProperty("os.name", "").toLowerCase();
        String str2 = System.getProperty("user.home", ".");
        if (str1.contains("win")) {
            String str3 = System.getenv("APPDATA");
            if (str3 != null) {
                return new File(str3, ".minecraft");
            }
            return new File(str2, ".minecraft");
        } else if (str1.contains("mac")) {
            return new File(str2, "Library/Application Support/minecraft");
        } else {
            return new File(str2, ".minecraft/");
        }
    }

    static final void I(GuiOptions var0, MouseEvent var1) {
        var0.addTab(var1);
    }

    static final void saveWaypointEvent(GuiOptions var0, ActionEvent var1) {
        var0.addWaypoint(var1);
    }

    static final void R(GuiOptions var0, ActionEvent var1) {
        var0.addMouseListener(var1);
    }
}