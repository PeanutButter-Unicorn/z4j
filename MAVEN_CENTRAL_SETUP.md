# Maven Central Release Setup Guide for z4j

This guide explains how to configure GitHub Secrets using the GitHub CLI (`gh`) so that `z4j` can automatically sign and publish releases to Maven Central via Sonatype Central Portal.

---

## 1. Required GitHub Secrets

The GitHub Actions workflow [`.github/workflows/release.yml`](file:///.github/workflows/release.yml) uses the following repository secrets:

| Secret Name | Description | Example / Format |
|---|---|---|
| `SONATYPE_USERNAME` | Sonatype Central Portal User Token Username | Generated 8-character token (e.g., `aBcDeFgH`) |
| `SONATYPE_PASSWORD` | Sonatype Central Portal User Token Password | Generated secret token |
| `GPG_SIGNING_KEY` | ASCII-armored GPG Private Key | `-----BEGIN PGP PRIVATE KEY BLOCK----- ...` |
| `GPG_PASSWORD` | Passphrase protecting the GPG private key | Passphrase string |
| `GPG_KEY_ID` *(Optional)* | 8 or 16-character GPG Key ID / Fingerprint | `12345678` or `1234567890ABCDEF` |

---

## 2. Step-by-Step Setup Using `gh`

Ensure you are logged in to the GitHub CLI:
```bash
gh auth status
```

### Step A: Sonatype Central Portal Credentials

1. Log in to [Sonatype Central](https://central.sonatype.com/).
2. Click your account avatar in the top right -> **View Account**.
3. Under **User Token**, click **Generate Token**.
4. Set the credentials in GitHub:

```bash
# Set token username
gh secret set SONATYPE_USERNAME --repo PeanutButter-Unicorn/z4j

# Set token password
gh secret set SONATYPE_PASSWORD --repo PeanutButter-Unicorn/z4j
```

---

### Step B: Export and Set GPG Signing Key

1. **Find your GPG Key ID**:
   ```bash
   gpg --list-secret-keys --keyid-format LONG
   ```
   Look for your sec key line, e.g.:
   ```text
   sec   rsa4096/ABCD1234EF567890 2026-01-01 [SC]
   ```
   In this example, the Key ID is `ABCD1234EF567890`.

2. **Set the ASCII-armored private key**:
   Pipe the armored private key directly into `gh secret set`:
   ```bash
   gpg --armor --export-secret-keys <YOUR_KEY_ID> | gh secret set GPG_SIGNING_KEY --repo PeanutButter-Unicorn/z4j
   ```
   *(Note: This sends the ASCII key directly to GitHub Secrets over HTTPS without writing any unencrypted files to disk).*

3. **Set the GPG Key Passphrase**:
   ```bash
   gh secret set GPG_PASSWORD --repo PeanutButter-Unicorn/z4j
   ```

4. *(Optional)* **Set the Key ID**:
   ```bash
   gh secret set GPG_KEY_ID --repo PeanutButter-Unicorn/z4j --body "<YOUR_KEY_ID>"
   ```

---

### Step C: Verify Public Key is Published to Keyservers

Sonatype verifies GPG signatures by fetching your public key from public keyservers. Ensure your public key has been uploaded:
```bash
gpg --keyserver keyserver.ubuntu.com --send-keys <YOUR_KEY_ID>
gpg --keyserver keys.openpgp.org --send-keys <YOUR_KEY_ID>
```

---

## 3. Triggering a Release

Once secrets are set, you can trigger a release in two ways:

### Option 1: Push a Version Tag (Recommended)

Pushing any tag matching `v*` or `[0-9]+.[0-9]+.*` triggers the release workflow automatically:
```bash
git tag 0.2.2
git push origin 0.2.2
```

The workflow will:
1. Extract the version from the tag (stripping any leading `v`).
2. Build and sign all artifacts.
3. Publish and release automatically to Sonatype Central Portal.
4. Create a GitHub Release with auto-generated release notes.

### Option 2: Run via GitHub CLI (`workflow_dispatch`)

You can trigger publishing without creating a tag manually:
```bash
gh workflow run release.yml --repo PeanutButter-Unicorn/z4j -f version=0.2.2
```

---

## 4. Monitoring Deployments

- Check GitHub Actions execution in the **Actions** tab of the `z4j` repository.
- Monitor publication progress and staging status at [Sonatype Central Deployments](https://central.sonatype.com/publishing/deployments).
