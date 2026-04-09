import type { Metadata } from "next";
import Link from "next/link";
import Image from "next/image";

export const metadata: Metadata = {
  title: "Privacy Policy — Jean",
  description:
    "Privacy Policy for Jean — AI Assistant. Your data stays on your device.",
};

export default function PrivacyPolicyPage() {
  return (
    <>
      {/* Simple nav for privacy page */}
      <nav className="border-b border-border py-4 px-6">
        <div className="mx-auto max-w-4xl flex items-center gap-2">
          <Link href="/" className="flex items-center gap-2">
            <Image
              src="/logo.png"
              alt="Jean logo"
              width={24}
              height={24}
              className="rounded-md"
            />
            <span className="text-sm font-bold">jean</span>
            <span className="text-sm text-muted-foreground">.works</span>
          </Link>
          <span className="text-muted-foreground mx-2">/</span>
          <span className="text-sm text-muted-foreground">Privacy Policy</span>
        </div>
      </nav>

      <main className="py-16 px-6">
        <article className="mx-auto max-w-4xl prose prose-invert prose-headings:text-foreground prose-p:text-muted-foreground prose-li:text-muted-foreground prose-strong:text-foreground prose-a:text-accent">
          <h1>Privacy Policy</h1>
          <p>
            <strong>Jean — AI Assistant</strong>
          </p>
          <p>
            <strong>Last updated:</strong> April 8, 2026
          </p>

          <hr />

          <h2>1. Introduction</h2>
          <p>
            This Privacy Policy describes how Roland Michelberger
            (&quot;Developer&quot;, &quot;we&quot;, &quot;us&quot;, or
            &quot;our&quot;) handles information in connection with the Jean
            mobile application (&quot;Jean&quot;, &quot;the App&quot;) available
            on the Apple App Store and Google Play Store.
          </p>
          <p>
            Jean is a local-first AI assistant app. We designed it with privacy
            at its core: <strong>your data stays on your device</strong>. We do
            not operate servers that collect, store, or process your personal
            data.
          </p>

          <hr />

          <h2>2. Information We Do Not Collect</h2>
          <p>
            <strong>
              We do not collect, transmit, or store any of your personal data on
              our servers.
            </strong>{" "}
            Specifically:
          </p>
          <ul>
            <li>We do not require account creation or login.</li>
            <li>We do not collect analytics or usage data.</li>
            <li>
              We do not use tracking technologies, advertising identifiers, or
              cookies.
            </li>
            <li>We do not use crash reporting services.</li>
            <li>
              We do not have access to your chat conversations, profile
              information, API keys, or any other data you enter into the App.
            </li>
          </ul>

          <hr />

          <h2>3. Data Stored on Your Device</h2>
          <p>
            Jean stores all data locally on your device. This includes:
          </p>
          <table>
            <thead>
              <tr>
                <th>Data type</th>
                <th>Storage method</th>
                <th>Purpose</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>
                  <strong>Chat conversations</strong>
                </td>
                <td>Local database (on-device)</td>
                <td>
                  To maintain your chat history and provide context to AI
                  conversations
                </td>
              </tr>
              <tr>
                <td>
                  <strong>User profile</strong> (name, bio, core values)
                </td>
                <td>Local database (on-device)</td>
                <td>To personalize AI assistant responses</td>
              </tr>
              <tr>
                <td>
                  <strong>Agent configurations</strong>
                </td>
                <td>Local database (on-device)</td>
                <td>
                  To store your custom agent settings, system prompts, and
                  preferences
                </td>
              </tr>
              <tr>
                <td>
                  <strong>Tool settings</strong>
                </td>
                <td>Local database / preferences (on-device)</td>
                <td>
                  To remember your tool enablement and auto-run preferences
                </td>
              </tr>
              <tr>
                <td>
                  <strong>Long-term memories</strong>
                </td>
                <td>Local database (on-device)</td>
                <td>
                  To provide personalized responses based on past conversations
                </td>
              </tr>
              <tr>
                <td>
                  <strong>API keys</strong>
                </td>
                <td>Secure storage (iOS Keychain / Android Keystore)</td>
                <td>
                  To authenticate with third-party AI providers on your behalf
                </td>
              </tr>
              <tr>
                <td>
                  <strong>App preferences</strong>
                </td>
                <td>Preferences storage (on-device)</td>
                <td>To store UI and general app settings</td>
              </tr>
            </tbody>
          </table>
          <p>
            <strong>You have full control over all of this data.</strong> You can
            view and delete chats, clear your profile, remove API keys, and
            uninstall the App at any time, which removes all locally stored data.
          </p>

          <hr />

          <h2>4. Third-Party AI Services</h2>
          <p>
            Jean allows you to connect to third-party AI providers using your
            own API keys. When you use the chat feature, the App sends your
            messages directly from your device to the AI provider you have
            configured. The supported providers are:
          </p>
          <ul>
            <li>
              <strong>Google (Gemini)</strong> —{" "}
              <a
                href="https://policies.google.com/privacy"
                target="_blank"
                rel="noopener noreferrer"
              >
                Google Privacy Policy
              </a>
            </li>
            <li>
              <strong>OpenAI</strong> —{" "}
              <a
                href="https://openai.com/privacy"
                target="_blank"
                rel="noopener noreferrer"
              >
                OpenAI Privacy Policy
              </a>
            </li>
            <li>
              <strong>Anthropic</strong> —{" "}
              <a
                href="https://www.anthropic.com/privacy"
                target="_blank"
                rel="noopener noreferrer"
              >
                Anthropic Privacy Policy
              </a>
            </li>
          </ul>

          <h3>Important details about third-party data sharing:</h3>
          <ul>
            <li>
              <strong>Your API key, your relationship.</strong> When you provide
              your own API key, the data exchange is directly between your device
              and the third-party provider. We are not a party to this exchange
              and do not act as an intermediary.
            </li>
            <li>
              <strong>What is sent.</strong> When you send a chat message, the
              App transmits your message content, relevant conversation context,
              and any applicable system prompt to the selected AI provider. If
              you have set up a user profile, relevant profile fields may be
              included in the prompt context.
            </li>
            <li>
              <strong>What is NOT sent.</strong> Your API keys are never shared
              with us. They are stored solely in your device&apos;s secure
              storage and used only to authenticate requests to the respective
              provider.
            </li>
            <li>
              <strong>We have no access.</strong> We cannot see, access, or
              retrieve any data sent between your device and these providers.
            </li>
          </ul>

          <hr />

          <h2>5. Device Permissions</h2>
          <p>
            Jean may request the following device permissions. Each permission is
            requested only when you activate the corresponding tool feature, and
            you can deny or revoke any permission at any time through your
            device&apos;s Settings.
          </p>
          <table>
            <thead>
              <tr>
                <th>Permission</th>
                <th>When requested</th>
                <th>Purpose</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>
                  <strong>Location</strong>
                </td>
                <td>When the location tool is activated</td>
                <td>To provide location-aware AI responses</td>
              </tr>
              <tr>
                <td>
                  <strong>Camera</strong>
                </td>
                <td>When the camera tool is activated</td>
                <td>
                  To capture photos or record videos for AI-assisted tasks
                </td>
              </tr>
              <tr>
                <td>
                  <strong>Microphone</strong>
                </td>
                <td>
                  When the camera tool records video, or during voice chat
                </td>
                <td>To record audio for video capture or voice interaction</td>
              </tr>
              <tr>
                <td>
                  <strong>Calendar</strong>
                </td>
                <td>When the calendar/event scheduler tool is activated</td>
                <td>To create calendar events on your behalf</td>
              </tr>
            </tbody>
          </table>
          <p>
            <strong>
              All data obtained through these permissions is processed locally on
              your device
            </strong>{" "}
            or sent directly to the third-party AI provider you have configured
            (under your own API key). We do not receive or have access to any
            data from these permissions.
          </p>

          <hr />

          <h2>6. Children&apos;s Privacy</h2>
          <p>
            Jean is not directed at children under the age of 13 (or the
            applicable age in your jurisdiction). We do not knowingly collect
            personal information from children. Since the App does not collect
            any personal data from any user, no special provisions for
            children&apos;s data are necessary.
          </p>

          <hr />

          <h2>7. Data Security</h2>
          <p>We take reasonable measures to protect your data:</p>
          <ul>
            <li>
              <strong>API keys</strong> are stored in platform-native secure
              storage (iOS Keychain / Android Keystore), which provides
              hardware-backed encryption where available.
            </li>
            <li>
              <strong>All network communication</strong> with third-party AI
              providers uses encrypted connections (HTTPS/TLS).
            </li>
            <li>
              <strong>No data leaves your device</strong> except when you
              actively use an AI chat feature, which sends messages directly to
              your chosen AI provider.
            </li>
          </ul>

          <hr />

          <h2>8. Data Retention and Deletion</h2>
          <ul>
            <li>
              <strong>All data is stored on your device only.</strong> There is
              no server-side data to retain or delete.
            </li>
            <li>
              <strong>You can delete individual chats</strong> (and their
              associated memories) at any time within the App.
            </li>
            <li>
              <strong>You can remove your API keys</strong> at any time within
              the App&apos;s settings.
            </li>
            <li>
              <strong>Uninstalling the App</strong> removes all locally stored
              data from your device.
            </li>
          </ul>

          <hr />

          <h2>9. Your Rights</h2>
          <p>
            Since Jean does not collect or process personal data on any server,
            traditional data subject rights (access, rectification, portability,
            erasure) are exercised directly on your device:
          </p>
          <ul>
            <li>
              <strong>Access &amp; portability:</strong> All your data is already
              on your device and under your control.
            </li>
            <li>
              <strong>Deletion:</strong> You can delete any data through the App
              or by uninstalling it.
            </li>
            <li>
              <strong>Restriction:</strong> You can revoke any device permission
              at any time.
            </li>
          </ul>

          <hr />

          <h2>10. Changes to This Privacy Policy</h2>
          <p>
            We may update this Privacy Policy from time to time. When we do, we
            will update the &quot;Last updated&quot; date at the top of this
            page.
          </p>

          <hr />

          <h2>11. Contact Us</h2>
          <p>
            If you have any questions or concerns about this Privacy Policy or
            the App&apos;s privacy practices, please contact us at:
          </p>
          <p>
            <strong>Roland Michelberger</strong>
            <br />
            Email:{" "}
            <a href="mailto:roland.michelberger@protonmail.ch">
              roland.michelberger@protonmail.ch
            </a>
          </p>

          <hr />

          <p className="text-sm">
            <em>
              This privacy policy is effective as of April 8, 2026.
            </em>
          </p>
        </article>
      </main>

      {/* Simple footer */}
      <footer className="border-t border-border py-8 px-6">
        <div className="mx-auto max-w-4xl text-center text-sm text-muted-foreground">
          <Link href="/" className="hover:text-foreground transition-colors">
            ← Back to jean.works
          </Link>
        </div>
      </footer>
    </>
  );
}
